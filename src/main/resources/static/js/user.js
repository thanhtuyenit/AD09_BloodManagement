$("#formAddUser").submit(function(event) {
	event.preventDefault(); // no submit
	if ($("#formAddUser").valid()) {
		addUser();
	}
});

function addUser() {
	var newUser= {}
	newUser["username"] = $('#username').val();
	newUser["password"] = $('#password').val();
	newUser["idRole"] = $('#idRole').val();
	var newDetailUser = {}
	newDetailUser["fullname"] = $('#fullname').val();
	newDetailUser["birthday"] = $('#birthday').val();
	newDetailUser["sex"] = $('input[name=sex]:checked').val();
	newDetailUser["phone"] = $('#phone').val();
	newDetailUser["address"] = $('#address').val();
	newDetailUser["email"] = $('#email').val();
	newDetailUser["user"] = newUser;
	$
			.ajax({
				type : "post",
				contentType : "application/json",
				dataType : 'json',
				url : '/admin/addUser',
				cache : false,
				data : JSON.stringify(newDetailUser),
				success : function(data) {
					if(data == 1){
						window.location.replace("/admin/danh-sach-nguoi-dung?msg=1");
					}else{
						window.location.replace("/admin/danh-sach-nguoi-dung?msg=0");
					}
					
				},
				error : function() {
					window.location.replace("/admin/danh-sach-nguoi-dung?msg=0");
				}
			});
}

$("#formIndex").submit(function(event) {
	event.preventDefault(); // no submit
	if ($("#formIndex").valid()) {
		editUserLogin();
	}
});

function editUserLogin() {
	var newUser= {}
	var newDetailUser = {}
	newDetailUser["fullname"] = $('#fullname').val();
	newDetailUser["birthday"] = $('#birthday').val();
	newDetailUser["sex"] = $('input[name=sex]:checked').val();
	newDetailUser["phone"] = $('#phone').val();
	newDetailUser["address"] = $('#address').val();
	newDetailUser["email"] = $('#email').val();
	newDetailUser["user"] = newUser;
	$
			.ajax({
				type : "post",
				contentType : "application/json",
				dataType : 'json',
				url : '/editUserLogin',
				cache : false,
				data : JSON.stringify(newDetailUser),
				success : function(data) {
					window.location.replace("/?msg=1");
				},
				error : function() {
					window.location.replace("/?msg=0");
				}
			});
}


$("#formEditUser").submit(function(event) {
	event.preventDefault(); // no submit
	if ($("#formEditUser").valid()) {
		editUser();
	}
});

function editUser() {
	var newUser= {}
	newUser["username"] = $('#username').val();
	newUser["password"] = $('#password').val();
	newUser["idRole"] = $('#idRole').val();
	newUser["idUser"] = $('#idUser').val();
	var newDetailUser = {}
	newDetailUser["fullname"] = $('#fullname').val();
	newDetailUser["birthday"] = $('#birthday').val();
	newDetailUser["sex"] = $('input[name=sex]:checked').val();
	newDetailUser["phone"] = $('#phone').val();
	newDetailUser["address"] = $('#address').val();
	newDetailUser["email"] = $('#email').val();
	newDetailUser["idUser"] = $('#idUser').val();
	newDetailUser["user"] = newUser;
	$
			.ajax({
				type : "PUT",
				contentType : "application/json",
				dataType : 'json',
				url : '/admin/editUser',
				cache : false,
				data : JSON.stringify(newDetailUser),
				success : function(data) {
					window.location.replace("/admin/danh-sach-nguoi-dung?msg=2");
				},
				error : function() {
					window.location.replace("/admin/danh-sach-nguoi-dung?msg=0");
				}
			});
}