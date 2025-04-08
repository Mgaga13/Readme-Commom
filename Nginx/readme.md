# Proxy & Nginx

## 1. Proxy là gì?

**Proxy**, hay chính xác hơn là **Proxy Server**, đóng vai trò như một máy chủ trung gian đứng giữa người dùng cuối và các trang web mà họ truy cập.

- **Chức năng:**  
  Proxy Server ngăn chặn việc khách hàng và máy chủ giao tiếp trực tiếp với nhau, từ đó nâng cao bảo mật.

![Proxy là gì?](https://statics.cdn.200lab.io/2024/07/proxy-la-gi-khai-niem.jpg?width=800)

## 2. Reverse Proxy là gì?

**Reverse Proxy** là một server trung gian giữa khách hàng và một hoặc nhiều máy chủ nội bộ.

- **Chức năng:**  
  Khi nhận được yêu cầu từ khách hàng, Reverse Proxy sẽ xác định máy chủ nào trong mạng sẽ nhận yêu cầu đó.  
  Khác với **Forward Proxy** – kiểm soát việc truy cập từ mạng nội bộ ra bên ngoài – **Reverse Proxy** kiểm soát truy cập từ bên ngoài vào các máy chủ nội bộ.

![Reverse Proxy](https://statics.cdn.200lab.io/2024/07/proxy-la-gi-reverse-proxy.png?width=800)

## 3. Ứng dụng thực tế của Proxy

Proxy được ứng dụng trong các tình huống sau:

- **Truy cập ẩn danh:**
  1. **Transparent Proxy:** Gửi địa chỉ thật của người dùng đến trang web đích.
  2. **Anonymous Proxy:** Che giấu địa chỉ IP thật.
  3. **High Anonymity Proxy:** Che giấu cả địa chỉ IP thật và việc sử dụng proxy.
- **Kiểm soát truy cập Internet**
- **Lưu trữ đệm (Caching)**
- **Mã hóa SSL (Secure Sockets Layer)**

## 4. HTTP cơ bản

**HTTP (HyperText Transfer Protocol)** là tập hợp các quy tắc truyền tin trên Internet, giúp đưa nội dung đến người dùng.

## 5. Tổng quan về Web Server

**Web Server** là thành phần lắng nghe các yêu cầu HTTP từ trình duyệt và gửi phản hồi lại cho người dùng.

## 6. Nginx là gì?

**Nginx** là phần mềm mã nguồn mở được sử dụng để làm máy chủ web và **Reverse Proxy**.

- **Ưu điểm của Nginx:**
  1. **Xử lý hàng nghìn kết nối đồng thời:** Nginx có khả năng xử lý hiệu quả số lượng lớn kết nối đồng thời trong khi tiêu tốn ít tài nguyên.
  2. **Phục vụ nhiều cồng việc:** Không chỉ phục vụ nội dung web mà còn hỗ trợ các giao thức như https,đóng vai trò trung gian giữa trình duyệt và trình duyệt web

![Nginx](https://statics.cdn.200lab.io/2024/09/nginx-la-gi-nginx-1.jpeg?width=1200)

## Lý do sử dụng Nginx

- Tốc độ xử lý/Tăng tốc ứng dụng

  1. **xử lý**: tăng tốc độ tải web, xử lý yêu cầu cùng lúc mà không bị chậm lại như các ứng dụng truyền thống sử dụng kiến trúc đồng bộ
  2. **Tăng tốc**: đóng vai trò làm proxy ngược (reverse proxy),có thể đặt Nginx phía trước các máy chủ để quản lý lượng truy cập hiệu quả

- Cân bằng tải dễ dàng
  1. Chia đều lưu lượng truy cập giữa các máy chủ
  2. Nhận tất cả yêu cầu từ người dùng và phân phối đến các máy chủ phía sau một cách hợp lý

```nginx
http { //phạm vi cấu hình cho các thiết lập HTTP của Nginx.
    upstream backend_servers {//nhóm các server backend để hỗ trợ cân bằng tả
        server server1.example.com;   # Máy chủ web đầu tiên
        server server2.example.com;   # Máy chủ web thứ hai
    }

    server {
        listen 80;  # Lắng nghe cổng 80 (HTTP)
        server_name example.com;

        location / {
            proxy_pass http://backend_servers;   # Chuyển tiếp yêu cầu đến nhóm máy chủ "backend_servers"
            proxy_set_header Host $host;//chuyển tiếp host ban đầu của client đến backend server.
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
            proxy_set_header X-Forwarded-Proto $scheme;
        }
    }
}
proxy_set_header//Đảm bảo rằng các header quan trọng
Forwarded-For và X-Forwarded-Proto được chuyển tiếp, hỗ trợ backend nhận diện chính xác thông tin của client.
```

- Khả năng mở rộng tốt
- Nâng cấp không gián đoạn
- Dễ cài đặt và bảo trì
- Dễ sử dụng

### About config Nginx

- Nginx có 2 thuật ngữ quan trọng là directive và context.

- Mọi thứ trong file config Nginx, đều là directive. Directive gồm có 2 loại là:

```
nginx -t // check syntax
nginx -s reload // reload nginx
/etc/hosts theme port va server-name
```

1.  **_Simple Directive_**

- Simple Directive bao gồm directive name và tham số, ngăn cách nhau bởi dấu cách và kết thúc bằng dấu chấm phẩy
  ex:directive_name parameter1 parameter2 ...;

```
listen 80;
server_name nginx-tutorial.test;
return 200 "Hello World!\n";
```

2.  **_Block Directive_**

- Block directive tương tự với simple directive ngoại trừ việc thay vì kết thúc bằng dấu chấm phẩy thì block directive kết với cặp ngoặc nhọn { } <br>
  events { }: Dùng để thiết lập cấu hình toàn cục<br>
  http{ }: Dùng để cấu hình Nginx xử lý các request HTTP và HTTPS. Và cũng như events, mỗi 1 file config sẽ chỉ có một http.<br>
  server{}: Nằm trong context http, được sử dụng để cấu hình cho từng virtual host. Có thể có nhiều context server trong context http.<br>
  main: Context main chính là file cấu hình.

```
events {

}

http {
    server {
        listen 80;
        server_name nginx-tutorial.test;

        return 200 "Hello, this response from port 80!\n";
    }


    server {
        listen 8080;
        server_name nginx-tutorial.test;

        return 200 "Hello, this response from port 8080!\n";
    }
}

```
