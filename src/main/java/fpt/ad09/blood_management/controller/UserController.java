package fpt.ad09.blood_management.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fpt.ad09.blood_management.model.DetailUser;
import fpt.ad09.blood_management.model.User;
import fpt.ad09.blood_management.service.DetailUserService;
import fpt.ad09.blood_management.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	DetailUserService detailUserService;

	String msgError = "Lỗi kết nối cơ sở dữ liệu!";

	@RequestMapping(value = "/admin/danh-sach-nguoi-dung", method = RequestMethod.GET)
	public String listUser(Model model, @RequestParam(required = false) String msg) {
		if (msg != null) {
			switch (msg) {
			case "1":
				model.addAttribute("msg", "Thêm người dùng thành công!");
				break;
			case "2":
				model.addAttribute("msg", "Chỉnh sửa người dùng thành công!");
				break;
			case "3":
				model.addAttribute("msg", "Xóa người dùng thành công!");
				break;
			case "0":
				model.addAttribute("msg", msgError);
				break;
			default:
				model.addAttribute("msg", null);
				break;
			}
		}

		model.addAttribute("listUser", detailUserService.findAll());
		return "/user";
	}

	@RequestMapping(value = "/admin/chi-tiet-nguoi-dung/{idUser}", method = RequestMethod.GET)
	public String detailUser(Model model, @PathVariable int idUser, @RequestParam(required = false) String msg) {
		if (msg != null) {
			switch (msg) {
			case "1":
				model.addAttribute("msg", "Mở khóa thành công!");
				break;
			case "2":
				model.addAttribute("msg", "Khóa thành công!");
				break;
			case "3":
				model.addAttribute("msg", "Không được khóa người dùng này!");
				break;
			case "4":
				model.addAttribute("msg", "Bạn không có quyền xóa người dùng này!");
				break;
			case "0":
				model.addAttribute("msg", msgError);
				break;
			default:
				model.addAttribute("msg", null);
				break;
			}
		}
		model.addAttribute("objDetailUser", detailUserService.findByIduser(idUser));
		return "/detailUser";
	}

	@RequestMapping(value = "/admin/doi-trang-thai-nguoi-dung/{idUser}", method = RequestMethod.GET)
	public String changeStatusUser(Model model, @PathVariable int idUser) {
		User userChange = userService.findByIdUser(idUser);
		int msg = 0;
		if (idUser == 1) {
			// Do not allow super administrators lock
			return "redirect:/admin/chi-tiet-nguoi-dung/1" + "?msg=3";
		} else {
			if (userChange.getEnabled() == 0) {
				userChange.setEnabled(1);
				msg = 1;
			} else {
				userChange.setEnabled(0);
				msg = 2;
			}
			userService.save(userChange);
			return "redirect:/admin/chi-tiet-nguoi-dung/" + idUser + "?msg=" + msg;

		}

	}

	@RequestMapping(value = "/admin/them-nguoi-dung", method = RequestMethod.GET)
	public String showAddUser(Model model) {
		return "/addUser";
	}

	@RequestMapping(value = "/admin/addUser", method = RequestMethod.POST)
	@ResponseBody
	public int addUser(Model model, @RequestBody DetailUser newDetailUser) {
		if (userService.findByUsername(newDetailUser.getUser().getUsername()) != null) {
			// already exist
			return 0;
		} else {
			newDetailUser.getUser().setPassword(BCrypt.hashpw(newDetailUser.getUser().getPassword(), BCrypt.gensalt()));
			newDetailUser.getUser().setEnabled(1); // enable
			userService.save(newDetailUser.getUser());
			int idDetailUser = userService.save(newDetailUser.getUser()).getIdUser();
			newDetailUser.setIdUser(idDetailUser);
			detailUserService.save(newDetailUser);
			return 1;
		}

	}

	@RequestMapping(value = "/admin/chinh-sua-nguoi-dung/{idUser}", method = RequestMethod.GET)
	public String showEditUser(Model model, @PathVariable int idUser) {
		model.addAttribute("userEdit", detailUserService.findByIduser(idUser));
		return "/editUser";
	}

	@RequestMapping(value = "/editUserLogin", method = RequestMethod.POST)
	@ResponseBody
	public int editUserLogin(Model model, @RequestBody DetailUser newDetailUser, Principal principal) {
		User userLogin = userService.findByUsername(principal.getName());
		newDetailUser.setUser(userLogin);
		newDetailUser.setIdUser(userLogin.getIdUser());
		detailUserService.save(newDetailUser);
		return 1;
	}

	@RequestMapping(value = "/doi-mat-khau", method = RequestMethod.GET)
	public String showChangePasswordUserLogin(Model model, @RequestParam(required = false) String msg) {
		if (msg != null) {
			switch (msg) {
			case "1":
				model.addAttribute("msg", "Mật khẩu cũ không chính xác!");
				break;
			case "0":
				model.addAttribute("msg", msgError);
				break;
			default:
				model.addAttribute("msg", null);
				break;
			}
		}
		return "/changePasswordUserLogin";
	}

	@RequestMapping(value = "/changePasswordUserLogin", method = RequestMethod.POST)
	public String changePasswordUserLogin(HttpServletRequest request, Model model, @RequestParam String password,
			@RequestParam String newPassword, Principal principal) {
		User userLogin = userService.findByUsername(principal.getName());
		if (BCrypt.checkpw(password, userLogin.getPassword())) {
			// true
			userLogin.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt()));
			userService.save(userLogin);
			HttpSession session = request.getSession(false);
			session.invalidate();
			return "redirect:/show-login?msg=3";
		} else {
			return "redirect:/doi-mat-khau?msg=1";
		}
	}

	@RequestMapping(value = "/admin/xoa-nguoi-dung/{idUser}", method = RequestMethod.GET)
	public String deleteUser(Model model, @PathVariable int idUser, Principal principal) {
		User userLogin = userService.findByUsername(principal.getName());
		if (userLogin.getIdRole() == 1 && idUser != 1) {
			// only for administrators to delete
			// Do not allow super administrators delete
			int result = userService.deleteByIdUser(idUser);
			System.out.println("result : " + result);
			if (result == 0) {
				return "redirect:/admin/danh-sach-nguoi-dung" + "?msg=0";
			} else {
				return "redirect:/admin/danh-sach-nguoi-dung" + "?msg=3";
			}

		} else {
			return "redirect:/admin/chi-tiet-nguoi-dung/" + idUser + "?msg=4";
		}

	}

	@RequestMapping(value = "/admin/editUser", method = RequestMethod.PUT)
	@ResponseBody
	public int editUser(Model model, @RequestBody DetailUser newDetailUser, Principal principal) {
		User user = userService.findByIdUser(newDetailUser.getIdUser());
		if (!newDetailUser.getUser().getPassword().equals("")) {
			// change password
			String password = BCrypt.hashpw(newDetailUser.getUser().getPassword(), BCrypt.gensalt());
			newDetailUser.getUser().setPassword(password);
			user.setPassword(password);
			newDetailUser.setUser(user);
		} else {
			newDetailUser.getUser().setPassword(user.getPassword());
		}
		return 1;
	}

	@RequestMapping(value = "/admin/search", method = RequestMethod.GET)
	public String index(Model model,@RequestParam String keyword,@RequestParam int typeSearch) {
		System.out.println("keyword: "+keyword);
		System.out.println("type: " +typeSearch);
		switch (typeSearch) {
		case 2:
			//find by address
			System.out.println("1");
			model.addAttribute("listUser", detailUserService.findByAddressContaining(keyword));
			model.addAttribute("size",detailUserService.findByAddressContaining(keyword).size());
			break;
		case 3:
			//find by phone
			System.out.println("2");
			model.addAttribute("listUser", detailUserService.findByPhoneContaining(keyword));
			model.addAttribute("size",detailUserService.findByPhoneContaining(keyword).size());
			break;
		default:
			//find by name
			System.out.println("3");
			model.addAttribute("listUser", detailUserService.findByFullnameContaining(keyword));
			model.addAttribute("size",detailUserService.findByFullnameContaining(keyword).size());
			break;
		}
		model.addAttribute("keyword", keyword);
		model.addAttribute("typeSearch", typeSearch);
		return "/search";
	}

}
