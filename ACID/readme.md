# ACID Properties in Database Transactions

## Transaction là gì?

Transaction đề cập đến một đơn vị logic của công việc bao gồm một hoặc nhiều hoạt động của cơ sở dữ liệu.

> Có thể coi một transaction là một tập hợp các câu query trong cơ sở dữ liệu.

**Ví dụ:** Transaction trong lĩnh vực tài chính

**Chuyển $100 từ Account 1 tới Account 2:**

1. Tạo một record để chuyển 100 từ tài khoản A tới tài khoản B (BEGIN transaction).
2. Đọc số dư của tài khoản 1.
3. Nếu số dư của tài khoản 1 ≥ 100, trừ tài khoản 1 đi 100.
4. Đọc số dư của tài khoản 2.
5. Cộng 100 vào số dư của tài khoản 2.
6. COMMIT để lưu thay đổi hoặc ROLLBACK nếu xảy ra lỗi.

---

## ACID là gì?

ACID là viết tắt của:

- **A**tomicity
- **C**onsistency
- **I**solation
- **D**urability

---

### I. Atomicity

Chuỗi hoạt động của database là không thể phân chia và không thể rút gọn. Tất cả các bước đều xảy ra hoặc không xảy ra gì cả.

**Ví dụ:** Nếu transaction lỗi → rollback. Nếu không lỗi → commit.

> Trích dẫn: “Được ăn cả ngã về không”

**Commit thành công:**  
![Atomicity commit](https://statics.cdn.200lab.io/2023/09/adherence-atomicity-1dd9f0f907a2dd562fa1020c7268e147.jpg?width=1200)

**Rollback khi thất bại:**  
![Atomicity rollback](https://statics.cdn.200lab.io/2023/09/violate-atomicity-67ae34336c8969d274e3b1a416836014.jpg?width=1200)

**NOTE:**

1. Transaction Logs
2. Two-Phase Commit (2PC)

---

### II. Consistency

Yêu cầu rằng tất cả các transaction chỉ có thể thay đổi dữ liệu theo những cách được cho phép.

**Ví dụ:** Sau khi thực hiện một transaction, tất cả các ràng buộc của CSDL phải được duy trì. Nếu vi phạm → rollback.

![Consistency](https://statics.cdn.200lab.io/2023/09/violate-consistency-9a118bdce2a235001e57a8fedbc1128b.jpg?width=1200)

---

### III. Isolation

Đảm bảo các transaction được thực thi một cách độc lập, không phụ thuộc lẫn nhau.

#### 1. Read phenomena (Hiện tượng đọc)

- **Dirty reads**: đọc những thay đổi chưa được commit.  
  ![Dirty reads](https://statics.cdn.200lab.io/2023/09/dirty-reads-29c7bb30a6c87a3532cfbfd8d96a3b6b.jpg?width=1200)

- **Repeatable reads**: đọc một bản ghi hai lần, nhưng lần thứ hai dữ liệu đã thay đổi do transaction khác.  
  ![repeatable reads](https://statics.cdn.200lab.io/2023/09/phantom-reads-9183a27c31c33f183b07391bd396b403.jpg?width=1200)

- **Phantom reads**: truy vấn nhiều lần, mỗi lần thấy số lượng bản ghi thay đổi do có bản ghi mới được thêm hoặc xóa.  
  ![Phantom reads](https://statics.cdn.200lab.io/2023/09/non-repeatable-reads-1414247624d5ead584ee449b24f8f17b.jpg?width=1200)

#### 2. Isolation levels (Cấp độ cô lập)

- **Serializable**: Thực hiện tuần tự, cô lập cao nhất.
- **Repeatable read**: Mỗi query chỉ thấy dữ liệu đã commit trước khi transaction bắt đầu.
- **Read committed**: Mỗi query chỉ thấy dữ liệu đã commit trước khi query bắt đầu.
- **Read uncommitted**: Có thể đọc dữ liệu chưa commit.

![Isolation](https://statics.cdn.200lab.io/2023/09/isolation-level-e5dc2e60e8d49ceb6dd8c93e6b6201f6.jpg?width=1200)

![Isolation level](https://statics.cdn.200lab.io/2023/09/isolation-level-read-phenomena-70c7459ac5c37a792a2aa75e7d6a0c7d.jpg?width=1200)

**NOTE:** Two-Phase Commit (2PC)

### IV: Durability

Durability (Tính bền vững) đảm bảo rằng những transaction đã commit, kết quả của nó sẽ được lưu trữ vĩnh viễn và không thể thay đổi hoặc mất mát, ngay cả trong trường hợp có lỗi hệ thống, cúp điện hoặc các sự cố khác.

**NOTE:**

1. Write-Ahead Logging (WAL)
2. Two-Phase Commit (2PC)
