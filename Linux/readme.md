# 📚 Tổng Hợp Kiến Thức Linux & DevOps Triển Khai Dự Án

---

## 🗂️ Hệ thống file và lệnh cơ bản

| Lệnh      | Chức năng                              |
| --------- | -------------------------------------- |
| `pwd`     | Hiển thị đường dẫn thư mục hiện tại    |
| `whoami`  | Hiển thị người dùng hiện tại           |
| `cd`      | Chuyển thư mục                         |
| `ls`      | Liệt kê file và folder                 |
| `mkdir`   | Tạo folder                             |
| `touch`   | Tạo file                               |
| `rm`      | Xoá file                               |
| `rm -rf`  | Xoá folder (recursive & force)         |
| `cp`      | Copy file/folder                       |
| `mv`      | Di chuyển hoặc đổi tên file/folder     |
| `echo`    | In chuỗi ra màn hình hoặc ghi vào file |
| `cat`     | Hiển thị nội dung file                 |
| `history` | Lịch sử lệnh                           |
| `tail`    | Xem dòng cuối của file                 |
| `sudo`    | Chạy lệnh với quyền root               |

---

## 🧠 Quản lý bộ nhớ & mạng

| Lệnh          | Chức năng              |
| ------------- | ---------------------- |
| `free`        | Xem bộ nhớ RAM         |
| `df`          | Xem dung lượng ổ đĩa   |
| `top`         | Giám sát tiến trình    |
| `hostnamectl` | Quản lý hostname       |
| `reboot`      | Khởi động lại          |
| `netstat`     | Kiểm tra kết nối mạng  |
| `ps`          | Kiểm tra tiến trình    |
| `ping`        | Kiểm tra kết nối       |
| `telnet`      | Kiểm tra cổng          |
| `traceroute`  | Kiểm tra đường đi mạng |
| `apt`         | Trình quản lý gói      |

---

## 👤 Quản lý User

| Lệnh               | Chức năng         |
| ------------------ | ----------------- |
| `useradd`          | Tạo user nhanh    |
| `adduser`          | Tạo user chi tiết |
| `deluser username` | Xoá user          |
| `su username`      | Chuyển sang user  |

---

## 👥 Quản lý Group

| Lệnh                             | Chức năng               |
| -------------------------------- | ----------------------- |
| `groupadd groupname`             | Tạo group               |
| `delgroup groupname`             | Xoá group               |
| `usermod -aG groupname username` | Thêm user vào group     |
| `groups username`                | Kiểm tra group của user |
| `deluser username groupname`     | Xoá user khỏi group     |

---

## 🔐 Quyền sở hữu & phân quyền

### Ownership

```bash
chown -R user:group folder/file
```

### Permission

- `rwx` → `r=4`, `w=2`, `x=1` → `7=4+2+1`
- Dạng: `drwxr-xr--` → `owner/group/others`

```bash
chmod g=rwx folder/file
chmod -R 750 folder/
```

---

## ✍️ VIM Editor

| Lệnh          | Ý nghĩa                  |
| ------------- | ------------------------ |
| `vi filename` | Mở file                  |
| `i`           | Chế độ insert            |
| `Esc`         | Chuyển về chế độ command |
| `dd`          | Xoá dòng                 |
| `yy`          | Copy dòng                |
| `p`           | Dán                      |
| `/`           | Tìm kiếm                 |
| `:wq`         | Lưu và thoát             |
| `:q!`         | Thoát không lưu          |
| `gg`          | Về đầu file              |
| `Shift + 4`   | Cuối dòng                |

---

## 🚀 Các bước triển khai dự án

### Cấu hình & build

1. **Dùng công cụ gì?**
2. **File cấu hình ở đâu?**
3. **Làm sao để build?**
4. **Run như thế nào?**

> ✅ Gợi ý: mỗi dự án nên có thư mục và user riêng

---

## 🌐 Deploy Project từ máy tính lên server

```bash
scp projectname user@ip:/home/user
su project_name
```

---

## ⚙️ Triển khai front-end với Nginx

### Cài Nginx

```bash
apt install nginx -y
cd /etc/nginx
vi sites-available/default
```

- Chỉnh cổng 80 → project

```bash
nginx -t
systemctl restart nginx
```

### Cấu hình Nginx cho Vue project

```bash
vi /etc/nginx/conf.d/todo.conf
```

```nginx
server {
    listen 8081;
    root /project/todolist/dist/;
    index index.html;
    try_files $uri $uri/ /index.html;
}
```

```bash
vi /etc/nginx/nginx.conf
usermod -aG todoList www-data
nginx -s reload
```

---

## 🛠️ Triển khai React với systemd

```bash
chown -R vision. /project/vision/
chmod -R 750 /project/vision

vi /lib/systemd/system/vision.service
```

```ini
[Service]
Type=simple
User=vision
Restart=on-failed
WorkingDirectory=/project/vision/
ExecStart=npm run start -- --port=3000
```

```bash
systemctl daemon-reload
systemctl start vision
```

---

## 📦 Tài liệu PM2

🔗 https://viblo.asia/p/deploy-reactjs-project-len-moi-truong-production-voi-pm2-Rk74a2jrJeO
