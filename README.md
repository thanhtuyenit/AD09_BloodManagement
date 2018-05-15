# AD09_BloodManagement
## Đồ án Phân tích và Thiết kế Hệ thống thông tin
#### Mô tả dự án
- Thiết kế phần quản lý hiến máu nhân đạo thành phố Đà Nẵng với các chức năng sau: (Chỉ mô tả những chức năng đã hoàn thành)
+ Đối với người đăng nhập vào hệ thống là administrators (gọi tắt là admin)
   -- Có toàn quyền với hệ thống
   -- Chỉnh sửa thông tin cá nhân đăng nhập
   -- Đổi mật khẩu cá nhân
   -- Xem toàn bộ danh sách người sử dụng hệ thống
   -- Thêm, sửa, xóa, khóa các người sử dụng của hệ thống (có thể reset lại password cho user khi user quên mật khẩu)
   -- Tìm kiếm người sử dụng hệ thống bằng nhiều tiêu chí(Họ tên, địa chỉ, số điện thoại...)
   -- Đăng xuất khỏi hệ thống
   -- Có 1 tài khoản với username là admin@gmail.com được mặc định là super admin, nghĩa là không có quyền đổi quyền sử dụng, khoá, xóa admin này. Các admin còn lại vẫn có thể bị xóa, khóa, đổi quyền bình th
+ Đối với người đăng nhập không phải là administrators (gọi tắt là user)
   -- Tài khoản của user được admin cấp để truy cập vào hệ thống
   -- user có thể chỉnh sửa thông tin cá nhân đăng nhập.
   -- Đổi mật khẩu cá nhân
   -- Đăng xuất khỏi hệ thống
  
 #### Cách building dự án
 - Dự án được xây dựng bằng công nghệ spring boot.
 - Cơ sở dữ liệu sử dụng: Mysql workbench
 - Giải nén và import project vào eclipse(yêu cầu phải có cài đặt các tool của spring hoặc sử dụng spring-tool-suite giành rieeng cho các dự án về spring)
 - improt database vào mysql workbench
 - Thay đổi thông số kết nối vào database bao gồm username và password của mysql workbench cá nhân trong file application.properties.
 - Database được lưu tại thư mục resources với tên là HumanitarianBloodDonationManagement_DaNangCity.sql
 - Tài khoản đăng nhập vào hệ thống:
   + amdin: 
      -- username: admin@gmail.com
      -- password: 123456 (đã được mã hóa bcrypt)
   + user:
      -- username: admin2@gmail.com
      -- password: 123456
