# JavaScript Event Loop

JavaScript là một ngôn ngữ lập trình đơn luồng, sử dụng cơ chế **event loop** để xử lý các tác vụ bất đồng bộ. Hiểu được cơ chế hoạt động của event loop sẽ giúp bạn viết code hiệu quả và tránh được các lỗi khó chịu.

## 1. Call Stack

- **Khái niệm:**  
  Call stack là nơi lưu trữ các hàm đang được gọi trong quá trình thực thi.

- **Hoạt động:**
  - Khi một hàm được gọi, nó sẽ được đưa vào call stack.
  - Khi hàm hoàn thành, nó sẽ được gỡ bỏ khỏi call stack.
- **Cơ chế FILO (First In Last Out):**  
  Hàm được đưa vào đầu tiên sẽ được gọi sau cùng.

## 2. Web API

- **Chức năng:**  
  Web API là các bộ công cụ cho phép xử lý các tác vụ bất đồng bộ như:
  - Xử lý sự kiện
  - Ajax, HTTP requests
  - Timers (setTimeout, setInterval)
- **Lưu ý:**  
  Web API không chạy trên call stack mà chạy riêng, sau đó đưa kết quả (callback) vào các hàng đợi (queue) khi sẵn sàng.

## 3. Task Queue

- **Định nghĩa:**  
  Task Queue là hàng đợi chứa các callback từ Web API khi các sự kiện bất đồng bộ đã sẵn sàng.

- **Công dụng:**  
  Các task từ Task Queue sẽ chờ đợi cho tới khi call stack trống và được chuyển vào call stack để thực thi.

## 4. Event Loop

- **Cách hoạt động:**

  - Event Loop liên tục kiểm tra call stack.
  - Bất cứ khi nào call stack trống, event loop sẽ lấy task đầu tiên từ Task Queue và đưa nó vào call stack để thực thi.

- **Ứng dụng:**  
  Điều này giúp JavaScript có thể xử lý các tác vụ bất đồng bộ một cách hiệu quả dựa trên mô hình callback-based APIs.

## 5. Microtask Queue

- **Đặc điểm:**  
  Microtask Queue là một hàng đợi riêng với độ ưu tiên cao hơn Task Queue.

- **Các tác vụ thường gặp:**
  - Promise handlers (ví dụ: `.then()`, `.catch()`)
  - Async/await (sau khi resolve)
  - MutationObserver callbacks
  - `queueMicrotask` callbacks
- **Quy tắc ưu tiên:**  
  Các microtask luôn được thực thi xong trước khi event loop kiểm tra lại Task Queue sau mỗi lần lặp của call stack.
