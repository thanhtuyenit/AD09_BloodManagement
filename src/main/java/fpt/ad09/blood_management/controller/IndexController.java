package fpt.ad09.blood_management.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fpt.ad09.blood_management.model.DetailUser;
import fpt.ad09.blood_management.model.User;
import fpt.ad09.blood_management.service.DetailUserService;
import fpt.ad09.blood_management.service.UserService;

@Controller
public class IndexController {
	@Autowired
	UserService userService;
	@Autowired
	DetailUserService detailUserService;

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied() {
		return "/403";
	}

	@RequestMapping(value = "/show-login", method = RequestMethod.GET)
	public String showLogin(@RequestParam(required = false) String msg, Model model) {
		if(msg != null) {
			switch (msg) {
			case "1":
				model.addAttribute("msg", "Tên đăng nhập hoặc mật khẩu không đúng!");
				break;
			case "2":
				model.addAttribute("msg", "Tài khoản của bạn bị khóa. Liên hệ admin để phục hồi!");
				break;
			case "3":
				model.addAttribute("msg", "Bạn vừa đổi mật khẩu. Đăng nhập lại để tiếp tục!");
				break;
			case "0":
				model.addAttribute("msg", "Lỗi kết nối cơ sở dữ liệu");
				break;
			default:
				model.addAttribute("msg", null);
				break;
			}
		}
		return "/login";
	}


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(@RequestParam(required = false) String msg, Principal principal, Model model, Authentication authentication, HttpServletRequest request) {
    	if(authentication == null) {
    		HttpSession session = request.getSession(false);
			session.invalidate();
    		return "redirect:/show-login";
    	}else {
        	User userLogin = userService.findByUsername(principal.getName());
        	DetailUser detailUser = detailUserService.findByIduser(userLogin.getIdUser());
    		if (userLogin.getEnabled() == 0) {
    			// user is block => no allowed access
    			HttpSession session = request.getSession(false);
    			session.invalidate();
    			return "redirect:/show-login?msg=2";
    		} else {
    			if (msg != null) {
    				switch (msg) {
    				case "1":
    					model.addAttribute("msg", "Cập nhật thông tin người dùng thành công!");
    					break;
    				case "0":
    					model.addAttribute("msg", "Lỗi kết nối cơ sở dữ liệu!");
    					break;
    				default:
    					model.addAttribute("msg", null);
    					break;
    				}
    			}
    			model.addAttribute("userLogin", detailUser);
    			return "/index";
    		}
    	}

    }

}
