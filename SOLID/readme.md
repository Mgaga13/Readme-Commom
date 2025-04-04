## SOLID

- SRP: Mỗi lớp (class) trong chương trình chỉ nên có một trách nhiệm duy nhất.
- OCP: Mở rộng tính năng mà không phải sửa đổi mã nguồn hiện có
- LSP: Một lớp con phải có thể thay thế cho các đối tượng của lớp cha mà không làm thay đổi tính đúng đắn
- ISP: Thay vì dùng 1 interface lớn, ta nên tách thành nhiều interface nhỏ, với nhiều mục đích cụ thể
- DPI: Các module cấp cao không nên phụ thuộc vào các module cấp thấp. Cả 2 nên phụ thuộc vào abstraction.Interface (abstraction) không nên phụ thuộc vào chi tiết, mà ngược lại. **_(Các class giao tiếp với nhau thông qua interface, không phải thông qua implementation.)_**
