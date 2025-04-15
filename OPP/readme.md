# 🧠 OOP Concepts in Java

## ✅ Encapsulation (Đóng Gói)

- Là quá trình đóng gói dữ liệu và các phương thức liên quan lại với nhau.
- Chỉ cho phép truy cập dữ liệu thông qua các phương thức được định nghĩa sẵn.
- Mục tiêu:
  - Bảo vệ dữ liệu khỏi thay đổi trái phép.
  - Giữ cho các đối tượng an toàn và dễ bảo trì.

### 🔒 Cách triển khai:

- **Biến của lớp** được khai báo là `private`.
- **Phương thức `public`** (`getters` và `setters`) được sử dụng để truy cập và cập nhật giá trị.

---

## 🧬 Inheritance (Kế Thừa)

- Cho phép một lớp kế thừa các thuộc tính và phương thức từ một lớp khác.
- Giúp **tái sử dụng mã nguồn** và **tổ chức chương trình** theo hướng phân cấp.

---

## 🔁 Polymorphism (Đa Hình)

- Cho phép một đối tượng có thể được xử lý theo nhiều hình thức khác nhau.
- Hai loại đa hình chính:

### ✅ Compile-time Polymorphism (Static):

- Thực hiện thông qua **method overloading** (nạp chồng phương thức).

### ✅ Run-time Polymorphism (Dynamic):

- Thực hiện thông qua **method overriding** (ghi đè phương thức).

---

## 🧩 Abstraction (Trừu Tượng)

- Ẩn đi chi tiết thực hiện, chỉ hiển thị các chức năng quan trọng cho người dùng.
- Người dùng chỉ cần biết _cái gì_ chương trình làm, không cần biết _làm như thế nào_.

### ✅ Cách đạt được abstraction:

- **Abstract class**: Cho phép 0-100% abstraction.
- **Interface**: Đạt được 100% abstraction.

---

## 🏗️ Class và Object

### 🔸 Class (Lớp)

- Là một **mẫu thiết kế (blueprint)** cho các đối tượng.
- Là một **thực thể logic**, không phải thực thể vật lý.

### 🔸 Object (Đối Tượng)

- Là một **thực thể có trạng thái và hành vi**.
- Là **instance (thể hiện)** của một class.
- Được tạo ra **tại thời điểm runtime** của chương trình.

### 🏡 Ví dụ minh họa:

- `Class` giống như **bản thiết kế của một ngôi nhà**.
- `Object` là **ngôi nhà thực tế** được xây dựng từ bản thiết kế đó.
