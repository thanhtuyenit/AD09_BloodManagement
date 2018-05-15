$(document).ready(function() {
	$("#formLogin").validate({
		rules : {
			"username" : {
				required : true,
			},

			"password" : {
				required : true,
			},
		},
		messages : {
			"username" : {
				required : "Vui lòng nhập tên đăng nhập!",
			},
			"password" : {
				required : "Vui lòng nhập mật khẩu!",
			},
		}
	});
});


$(document).ready(function() {
	$("#formAddUser").validate({
		rules : {
			"username" : {
				required : true,
				minlength : 3,
				maxlength : 50
			},

			"password" : {
				required : true,
				minlength : 3,
				maxlength : 50
			},

			"repassword" : {
				required : true,
				equalTo : "#password",
			},
			
			"fullname" : {
				required : true,
				minlength : 3,
				maxlength : 50
			},
			"birthday" : {
				required : true,
			},
			"phone" : {
				required : true,
				minlength : 10,
				maxlength : 11
			},
			"address" : {
				required : true,
				minlength : 3,
				maxlength : 100
			},
			"email" : {
				required : true,
				minlength : 3,
				maxlength : 100,
				email: true
			},
		},
		messages : {
			"username" : {
				required : "Vui lòng nhập tên đăng nhập!",
				minlength : "Tên đăng nhập quá ngắn!",
				maxlength : "Tên đăng nhập quá dài!"
			},
			"password" : {
				required : "Vui lòng nhập mật khẩu!",
				minlength : "Mật khẩu quá ngắn!",
				maxlength : "Mật khẩu quá dài!"
			},

			"repassword" : {
				required : "Vui lòng nhập mật khẩu xác nhận!",
				equalTo : "Mật khẩu xác nhận phải trùng với mật khẩu đã nhập!",
			},
			
			"fullname" : {
				required : "Vui lòng nhập họ tên!",
				minlength : "Họ tên quá ngắn!",
				maxlength : "Họ tên quá dài!"
			},
			"birthday" : {
				required : "Vui lòng chọn ngày sinh!",
			},
			"phone" : {
				required : "Vui lòng nhập số điện thoại!",
				minlength : "Số điện thoại quá ngắn!",
				maxlength : "Số điện thoại quá dài!"
			},
			"address" : {
				required : "Vui lòng nhập địa chỉ!",
				minlength : "Địa chỉ quá ngắn!",
				maxlength : "Địa chỉ quá dài!"
			},
			"email" : {
				required : "Vui lòng nhập tên email!",
				minlength : "Địa chỉ email quá ngắn!",
				maxlength : "Địa chỉ email nhập quá dài!",
				email: "Vui lòng nhập đúng định dạng email!"
			},
		}
	});
});

$(document).ready(function() {
	$("#formIndex").validate({
		rules : {
			"fullname" : {
				required : true,
				minlength : 3,
				maxlength : 50
			},
			"birthday" : {
				required : true,
			},
			"phone" : {
				required : true,
				minlength : 10,
				maxlength : 11
			},
			"address" : {
				required : true,
				minlength : 3,
				maxlength : 100
			},
			"email" : {
				required : true,
				minlength : 3,
				maxlength : 100,
				email: true
			},
		},
		messages : {
			"fullname" : {
				required : "Vui lòng nhập họ tên!",
				minlength : "Họ tên quá ngắn!",
				maxlength : "Họ tên quá dài!"
			},
			"birthday" : {
				required : "Vui lòng chọn ngày sinh!",
			},
			"phone" : {
				required : "Vui lòng nhập số điện thoại!",
				minlength : "Số điện thoại quá ngắn!",
				maxlength : "Số điện thoại quá dài!"
			},
			"address" : {
				required : "Vui lòng nhập địa chỉ!",
				minlength : "Địa chỉ quá ngắn!",
				maxlength : "Địa chỉ quá dài!"
			},
			"email" : {
				required : "Vui lòng nhập tên email!",
				minlength : "Địa chỉ email quá ngắn!",
				maxlength : "Địa chỉ email nhập quá dài!",
				email: "Vui lòng nhập đúng định dạng email!"
			},
		}
	});
});


$(document).ready(function() {
	$("#formChangePassword").validate({
		rules : {
			"password" : {
				required : true,
				minlength : 3,
				maxlength : 50
			},
			"newPassword" : {
				required : true,
				minlength : 3,
				maxlength : 50
			},
			"rePassword" : {
				required : true,
				equalTo : "#newPassword",
			},
		},
		messages : {
			"password" : {
				required : "Vui lòng nhập mật khẩu cũ!",
				minlength : "Mật khẩu cũ quá ngắn!",
				maxlength : "Mật khẩu cũ quá dài!"
			},
			
			"newPassword" : {
				required : "Vui lòng nhập mật khẩu mới!",
				minlength : "Mật khẩu mới quá ngắn!",
				maxlength : "Mật khẩu mới quá dài!"
			},

			"rePassword" : {
				required : "Vui lòng nhập mật khẩu xác nhận!",
				equalTo : "Mật khẩu xác nhận phải trùng với mật khẩu đã nhập!",
			},
			
		}
	});
});

$(document).ready(function() {
	$("#formEditUser").validate({
		rules : {
			"password" : {
				required : false,
				minlength : 3,
				maxlength : 50
			},

			"repassword" : {
				required : false,
				equalTo : "#password",
			},
			
			"fullname" : {
				required : true,
				minlength : 3,
				maxlength : 50
			},
			"birthday" : {
				required : true,
			},
			"phone" : {
				required : true,
				minlength : 10,
				maxlength : 11
			},
			"address" : {
				required : true,
				minlength : 3,
				maxlength : 100
			},
			"email" : {
				required : true,
				minlength : 3,
				maxlength : 100,
				email: true
			},
		},
		messages : {
			"password" : {
				minlength : "Mật khẩu quá ngắn!",
				maxlength : "Mật khẩu quá dài!"
			},

			"repassword" : {
				equalTo : "Mật khẩu xác nhận phải trùng với mật khẩu đã nhập!",
			},
			
			"fullname" : {
				required : "Vui lòng nhập họ tên!",
				minlength : "Họ tên quá ngắn!",
				maxlength : "Họ tên quá dài!"
			},
			"birthday" : {
				required : "Vui lòng chọn ngày sinh!",
			},
			"phone" : {
				required : "Vui lòng nhập số điện thoại!",
				minlength : "Số điện thoại quá ngắn!",
				maxlength : "Số điện thoại quá dài!"
			},
			"address" : {
				required : "Vui lòng nhập địa chỉ!",
				minlength : "Địa chỉ quá ngắn!",
				maxlength : "Địa chỉ quá dài!"
			},
			"email" : {
				required : "Vui lòng nhập tên email!",
				minlength : "Địa chỉ email quá ngắn!",
				maxlength : "Địa chỉ email nhập quá dài!",
				email: "Vui lòng nhập đúng định dạng email!"
			},
		}
	});
});
