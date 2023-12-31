**MÔN:** LẬP TRÌNH WEB

**ĐỀ TÀI**: THIẾT KẾT WEBSITE BÁN ĐIỆN THOẠI THÔNG MINH **TECHGADGET**

# MỤC LỤC
[**LỜI CẢM ƠN**	1](#_toc152702008)

[**CHƯƠNG 1: TỔNG QUAN VỀ HỆ THỐNG**	2](#_toc152702009)

[**1. Giới thiệu**	2](#_toc152702010)

[**2. Mục tiêu và phạm vi**	2](#_toc152702011)

[**3. Công nghệ sử dụng**	2](#_toc152702012)

[**4. Các đường dẫn**	2](#_toc152702013)

[**CHƯƠNG 2: THIẾT KẾ HỆ THỐNG**	3](#_toc152702014)

[**1. Class Diagram:**	3](#_toc152702015)

[**2. Cấu trúc phân luồng dữ liệu**	3](#_toc152702016)

[**2.1 Model**	3](#_toc152702017)

[**2.2 Controller**	5](#_toc152702018)

[**2.3 Utility**	5](#_toc152702019)

[**3. Chức năng bài toán**	5](#_toc152702020)

[**3.1 Đối với người dùng**	5](#_toc152702021)

[**3.1.1 Đăng ký**	5](#_toc152702022)

[**3.1.2** **Đăng nhập/đăng xuất**	9](#_toc152702023)

[**3.1.3 Quên mật khẩu**	11](#_toc152702024)

[**3.1.4 Ghi nhớ đăng nhập**	12](#_toc152702025)

[**3.1.5 Thêm vào giỏ hàng**	14](#_toc152702026)

[**3.1.6 Thanh toán**	17](#_toc152702027)

[**3.1.7 Cập nhật thông tin cá nhân**	19](#_toc152702028)

[**3.1.8 Xem thông tin đơn hàng**	20](#_toc152702029)

[**3.2 Đối với người quản trị**	20](#_toc152702030)

[**3.2.1 Quản lý người dùng**	20](#_toc152702031)

[**3.2.2 Quản lý thương hiệu**	23](#_toc152702032)

[**3.2.3 Quản lý sản phẩm**	24](#_toc152702033)

[**3.2.4 Quản lý đơn đặt hàng**	24](#_toc152702034)

[**CHƯƠNG 3: KẾT LUẬN**	25](#_toc152702035)

[**1. Kết quả đạt được**	25](#_toc152702036)

[**2. Phân công công việc**	25](#_toc152702037)

[**3. Hạn chế**	26](#_toc152702038)

[**4. Hướng phát triển**	26](#_toc152702039)

[**4.1 Class Diagram**	26](#_toc152702040)

[**4.2 Thay đổi (so với bản đã triển khai trên hosting)**	27](#_toc152702041)



# <a name="_toc152702008"></a>**LỜI CẢM ƠN**
`	`Lời đầu tiên xin cảm ơn GV, ThS Mai Anh Thơ đã truyền đạt kiến thức, đầu tư tâm huyết và thời gian để giúp nhóm chúng tôi hoàn thiện đồ án. Điều mà chúng tôi nhận được chính là kiến thức chuyên môn, kỹ năng làm việc nhóm, phân tích thiết kế Class Diagram được được vững vàng hơn qua đồ án cuối kỳ.

`	`Trong quá trình xây dựng đồ án, vẫn sẽ có những thiếu sót nhất định. Mong cô đưa ra những lời góp ý giúp chúng tôi hoàn thiện.

Xin chân thành cảm ơn cô!


# <a name="_toc152702009"></a>**CHƯƠNG 1: TỔNG QUAN VỀ HỆ THỐNG**
# <a name="_toc152702010"></a>**1. Giới thiệu**
Trong đề tài đồ án cuối kỳ của môn Lập trình Web lần này, nhóm chúng tôi lựa chọn thiết kế và xây dựng một trang web bán hàng trực tuyến về điện thoại thông minh TechGadget. Hệ thống sẽ chia người dùng thành hai vai trò là người dùng thông thường và người quản trị viên. Người dùng sẽ có những nghiệp vụ cơ bản như đăng nhập, đăng ký, thêm vào giỏ hàng, thanh toán, gửi mail xác nhận đơn hàng… Còn người quản trị viên sẽ có những nghiệp vụ như quản lý sản phẩm, quản lý người dùng và quản các đơn hàng.
# <a name="_toc152702011"></a>**2. Mục tiêu và phạm vi**
Triển khai web hosting và kết nối database online. Bài toán được xây dựng theo cấu trúc mô hình MVC, mapping cơ sở dữ liệu bằng Hibernate, các module servlet API chỉ sử dụng hai phương thức là doGet và doPost, mapping annotation. Cơ chế giỏ hàng và phiên đăng nhập được hoạt động trên session.
# <a name="_toc152702012"></a>**3. Công nghệ sử dụng**
- **IDE:** Eclipse, IntelliJ.
- **Ngôn ngữ lập trình:** Java.
- **Java Development Kit:** 17.
- **Server Runtime:** Apache Tomcat v9.0.
- **Quản lý dự án:** Maven Project, Github.
- **Mô hình:** MVC
- **Deployment:** Render, Railway.
- **Framework:** Hibernate.
- **Module:** javax.servlet-api, javax.mail-api và javax.mail.
- **Thư viện:** mysql-connector-java, Standard Taglibs (taglibs và jstl), commons-fileupload.
# <a name="_toc152702013"></a>**4. Các đường dẫn**
**Link Web đã deloy:** <https://techgadget-store.onrender.com/Smartphone_Webshop/>

# <a name="_toc152702014"></a>**CHƯƠNG 2: THIẾT KẾ HỆ THỐNG**
# <a name="_toc152702015"></a>**1. Class Diagram:**
![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.003.jpeg)
# <a name="_toc152702016"></a>**2. Cấu trúc phân luồng dữ liệu**
# <a name="_toc152702017"></a>**2.1 Model**
Các lớp model về các thực thể của database được mapping theo JPA annotation.

Một Order sẽ chứa nhiều OrderDetail nên trong hai class này, ngoài những phương thức get/ set cơ bản, chúng tôi còn cài đặt thêm một số phương thức xử lý khác.

Thêm, xóa, sửa một OrderDetail ở class Order:

|<p>`	`**public** **void** addOrderDetail(OrderDetail orderDetail) {</p><p>`		`**int** product\_id = orderDetail.getProduct().getId();</p><p>`		`**for** (**int** i = 0; i < orderDetails.size(); i++) {</p><p>`			`OrderDetail orderDetail1\_temp = orderDetails.get(i);</p><p>`			`**if** (orderDetail1\_temp.getProduct().getId() == product\_id) {</p><p>`				`orderDetails.get(i).setQuantity(orderDetails.get(i).getQuantity() + 1);</p><p>`				`**return**;</p><p>`			`}</p><p>`		`}</p><p>`		`orderDetails.add(orderDetail);</p><p>`	`}</p>|
| - |
|<p>`	`**public** **void** removeOrderDetail(OrderDetail orderDetail) {</p><p>`		`**int** product\_id = orderDetail.getProduct().getId();</p><p>`		`**for** (**int** i = 0; i < orderDetails.size(); i++) {</p><p>`			`OrderDetail orderDetail1\_temp = orderDetails.get(i);</p><p>`			`**if** (orderDetail1\_temp.getProduct().getId() == product\_id) {</p><p>`				`orderDetails.remove(i);</p><p>`				`**return**;</p><p>`			`}</p><p>`		`}</p><p>`	`}</p>|
|<p>`	`**public** **void** removeOrderDetail(OrderDetail orderDetail) {</p><p>`		`**int** product\_id = orderDetail.getProduct().getId();</p><p>`		`**for** (**int** i = 0; i < orderDetails.size(); i++) {</p><p>`			`OrderDetail orderDetail1\_temp = orderDetails.get(i);</p><p>`			`**if** (orderDetail1\_temp.getProduct().getId() == product\_id) {</p><p>`				`orderDetails.remove(i);</p><p>`				`**return**;</p><p>`			`}</p><p>`		`}</p><p>`	`}</p>|



Tính tổng tiền một mặt hàng ở OrderDetail:

|<p>`	`**public** **double** getTotal() {</p><p>`		`**double** total = product.getPrice() \* quantity;</p><p>`		`**return** total;</p><p>`	`}</p>|
| - |

Từ đó, tính tổng tiền toàn độ sản phẩm ở Order:

|<p>`	`**public** **double** getTotal() {</p><p>`		`**double** total = 0;</p><p>`		`**for** (**int** i = 0; i < orderDetails.size(); i++) {</p><p>`			`total += orderDetails.get(i).getTotal();</p><p>`		`}</p><p>`		`**return** total;</p><p>`	`}</p>|
| - |
# <a name="_toc152702018"></a>**2.2 Controller**
Áp dụng kỹ thuật generic, tạo một lớp BaseDAO có các thủ tục cơ bản như thêm, xóa, sửa, tìm kiếm bằng ID ở tầng database dưới được hỗ trợ bởi Hibernate. Các lớp model DAO khác sẽ kế thừa từ lớp base đó và có thể triển khai thêm các phương thức kết nối xử lý database khác nếu có.

Cuối cùng, lớp service là lớp trung gian gọi lại hết các phương thức và trả về kết quả của DAO. Chúng ta sẽ tạo một đối tượng service của model để sử dụng nó trong các lớp controller và gọi kết nối các thủ tục database đã viết trước đó. Các lớp controller được mapping annotation với nhiều URL tương ứng với nhiều action request cho mỗi đối tượng cần thao tác.
# <a name="_toc152702019"></a>**2.3 Utility**
- **Constant:** Lưu các đối tượng cookies.
- **Email:** Sử dụng Java Mail API, cài đặt các thuộc tính giao thức để gửi email, các hàm gửi mail xác nhận, hàm random mã code xác thực.
- **HibernateUtility:** Tạo sessionFactory được build từ file hibernate.cfg.xml.
- **Upload:** Chứa hàm convert mảng byte thành kiểu String, dùng để lưu ảnh được upload từ máy của người dùng.
# <a name="_toc152702020"></a>**3. Chức năng bài toán**
# <a name="_toc152702021"></a>**3.1 Đối với người dùng**
# <a name="_toc152702022"></a>**3.1.1 Đăng ký**
Khi người dùng gửi thông tin đã nhập từ form đăng ký, sẽ truyền vào servlet, gọi lại phương thức random mã code và gửi lại mã code đó qua mail của người dùng từ util của Email. Sau khi xác nhận đăng ký thì tài khoản sẽ được kích hoạt để đăng nhập.

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.004.png)

Code servlet

|<p>protected void register(HttpServletRequest request, HttpServletResponse response)</p><p>`      `throws ServletException, IOException {</p><p>`   `String name = request.getParameter("name");</p><p>`   `String email = request.getParameter("email");</p><p>`   `String password = request.getParameter("password");</p><p>`   `String confirmPassword = request.getParameter("confirmPassword");</p><p>`   `String alertMsg = "";</p><p>`   `if (userService.checkExistEmail(email)) {</p><p>`      `alertMsg = "The email already exists!";</p><p>`      `request.setAttribute("error", alertMsg);</p><p>`      `request.getRequestDispatcher("/views/home/register.jsp").forward(request, response);</p><p>`   `} else {</p><p>`      `if (!password.equals(confirmPassword)) {</p><p>`         `alertMsg = "The confirmation password does not match.";</p><p>`         `request.setAttribute("error", alertMsg);</p><p>`         `request.getRequestDispatcher("/views/home/register.jsp").forward(request, response);</p><p>`      `} else {</p><p>`         `Email sm = new Email();</p><p>`         `String code = sm.getRandom();</p><p>`         `User user = new User(name, email, code);</p><p>`         `String title = "TechGadget - Activate Account";</p><p>`         `String text = "Your code is: " + user.getCode();</p><p>`         `boolean test = sm.sendEmail(user.getEmail(), title, text);</p><p>`         `if (test) {</p><p>`            `HttpSession session = request.getSession();</p><p>`            `session.setAttribute("user", user);</p><p>`            `boolean isSuccess = userService.register(name, email, password, code);</p><p>`            `if (isSuccess) {</p><p>`               `request.getRequestDispatcher("/views/home/verify.jsp").forward(request, response);</p><p>`            `} else {</p><p>`               `alertMsg = "System error!";</p><p>`               `request.setAttribute("error", alertMsg);</p><p>`               `request.getRequestDispatcher("/views/home/register.jsp").forward(request, response);</p><p>`            `}</p><p>`         `} else {</p><p>`            `PrintWriter out = response.getWriter();</p><p>`            `out.println("Error while sending the email!");</p><p>`         `}</p><p>`      `}</p><p>`   `}</p><p>}</p>|
| - |

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.005.png)

Code Servlet:

|<p>private void verify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {</p><p>`   `HttpSession session = request.getSession();</p><p>`   `User user = (User) session.getAttribute("user");</p><p>`   `User retrievedUser = userService.findByEmail(user.getEmail());</p><p>`   `String code = request.getParameter("authcode");</p><p>`   `if (code.equals(retrievedUser.getCode())) {</p><p>`      `retrievedUser.setStatus(Status.*ACTIVE*);</p><p>`      `userService.update(retrievedUser);</p><p>`      `request.setAttribute("message", "Account successfully activated!");</p><p>`   `} else {</p><p>`      `request.setAttribute("error", "Invalid activation code, please double-check.");</p><p>`   `}</p><p>`   `request.getRequestDispatcher("/views/home/verify.jsp").forward(request, response);</p><p>}</p>|
| - |

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.006.png)

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.007.png)

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.008.png)
# <a name="_toc152702023"></a>**3.1.2** **Đăng nhập/đăng xuất**
Sau khi đã đăng ký và kích hoạt, người dùng tiến hành đăng nhập, đăng nhập sẽ kiểm tra người dùng có trong database không, nếu có, và đúng thông tin sẽ được đăng nhập vào.

Ở phần giao diện header trên thanh navbar, nếu người dùng là admin sẽ kiểm tra bằng jstl tag if để hiện thêm một số menu để quản lý.

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.009.png)

Chức năng ShowPassword cho phép hiện password người dùng đang nhập:

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.010.png)

Sau khi đăng xuất, sẽ xóa cookie remember và session “account” đã đăng nhập.

|<p>`	`**private** **void** logout(HttpServletRequest request, HttpServletResponse response) **throws** ServletException, IOException {</p><p>`		`HttpSession session = request.getSession();</p><p>`		`session.removeAttribute("account");</p><p>`		`Cookie[] cookies = request.getCookies();</p><p>`		`**if** (cookies != **null**) {</p><p>`			`**for** (Cookie cookie : cookies) {</p><p>`				`**if** (Constant.***COOKIE\_REMEMBER***.equals(cookie.getName())) {</p><p>`					`cookie.setMaxAge(0);</p><p>`					`response.addCookie(cookie);</p><p>`				`}</p><p>`			`}</p><p>`		`}</p><p>`		`response.sendRedirect(request.getContextPath() + "/login");</p><p>`	`}</p>|
| - |
# <a name="_toc152702024"></a>**3.1.3 Quên mật khẩu**
![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.011.png)



Người dùng quên mật khẩu sẽ điền email và tiến hành xác nhận như bước ở bước đăng ký, và phải nhập đúng email đã được đăng ký, nếu không sẽ thông báo lỗi.

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.012.png)

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.013.png)
# <a name="_toc152702025"></a>**3.1.4 Ghi nhớ đăng nhập**
Trước khi vào form đăng nhập, sẽ kiểm tra người dùng có lưu cookie của tài khoản trước đó, nếu có sẽ sử dụng email tạo lại một session user và cho đăng nhập luôn mà không cần nhập thông tin.


|<p>`	`**private** **void** getLogin(HttpServletRequest request, HttpServletResponse response)</p><p>`			`**throws** ServletException, IOException {</p><p>`		`HttpSession session = request.getSession(**false**);</p><p>`		`**if** (session != **null** && session.getAttribute("account") != **null**) {</p><p>`			`waiting(request, response);</p><p>`			`**return**;</p><p>`		`}</p><p>`		`Cookie[] cookies = request.getCookies();</p><p>`		`**if** (cookies != **null**) {</p><p>`			`**for** (Cookie cookie : cookies) {</p><p>`				`**if** (cookie.getName().equals("email")) {</p><p>`					`session = request.getSession(**true**);</p><p>`					`String email = cookie.getValue();</p><p>`					`session.setAttribute("email", email);</p><p>`					`User user = userService.findByEmail(email);</p><p>`					`session.setAttribute("account", user);</p><p>`					`waiting(request, response);</p><p>`					`**return**;</p><p>`				`}</p><p>`			`}</p><p>`		`}</p><p>`		`request.getRequestDispatcher("/views/home/login.jsp").forward(request, response);</p><p>`	`}</p>|
| - |

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.014.png)

Và “Remember me” cho phép lưu cookie tài khoản lại

|<p>private void saveRemeberMe(HttpServletResponse response, String email) {</p><p>`   `Cookie cookie = new Cookie(Constant.*COOKIE\_REMEMBER*, email);</p><p>`   `cookie.setMaxAge(30 \* 60);</p><p>`   `response.addCookie(cookie);</p><p>}</p>|
| - |
# <a name="_toc152702026"></a>**3.1.5 Thêm vào giỏ hàng**
Giao diện trang chủ sau khi đăng nhập vào của người dùng.

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.015.png)

Giao diện giỏ hàng:

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.016.png)



Giao diện shop (cho phép thêm vào giỏ hàng):

Ở mục Shop, người dùng có thể tìm kiếm từ khóa tìm tìm ra các sản phẩm mà thuộc tính của nó chứa các từ khóa đã nhập. Ngoài ra còn có kỹ thuật phân trang (pagination) khi giới hạn mỗi trang chỉ show 8 sản phẩm, chuyển sang những trang tiếp theo sẽ chứa những sản phẩm tiếp theo. Tất cả đều được truyền qua servlet và kết nối qua các phương thức DAO để xử lý.

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.017.png)

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.018.png)

Người dùng bấm vào nút details → Add to cart, hoặc bấm trực tiếp vào hình ảnh sản phẩm.

Người dùng được phép thêm hàng vào giỏ cả khi chưa đăng ký, được xem chi tiết sản phẩm.

`	`Giỏ hàng sẽ được lưu theo phiên hoạt động của session trên server, do đó, người dùng trước và sau đăng nhập miễn là trong phiên session, giỏ hàng vẫn sẽ được lưu cho tới khi kết thúc hoặc tiến hành thanh toán.



Giao diện giỏ hàng, khi đã thêm hàng vào giỏ:

Người dùng có cập nhật số lượng sản phẩm và xóa đơn hàng.

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.019.png)
# <a name="_toc152702027"></a>**3.1.6 Thanh toán**
Nếu đã đăng nhập rồi, thì chỉ cần chọn Proceed To Checkout thể thanh toán.

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.020.png)

Nhập thông tin để tạo đơn hàng, và gửi thông tin đơn hàng đến mail.

Sau khi thanh toán sẽ xóa đi session “cart” của giỏ hàng sẽ được xóa đi.

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.021.png)

Mail xác nhận đơn hàng sẽ được gửi về người dùng thông qua mail tài khoản đã đăng ký.

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.022.png)

Code Servlet:

|<p>private void checkout(HttpServletRequest request, HttpServletResponse response)</p><p>`      `throws ServletException, IOException {</p><p>`   `Email sm = new Email();</p><p>`   `HttpSession session = request.getSession();</p><p>`   `Order order = (Order) session.getAttribute("order");</p><p>`   `if (order == null) {</p><p>`      `order = new Order();</p><p>`   `}</p><p>`   `String toEmail = request.getParameter("email");</p><p>`   `order.setUser(userService.findByEmail(toEmail));</p><p>`   `order.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));</p><p>`   `order.setAddress(request.getParameter("address"));</p><p>`   `order.setPhone(request.getParameter("phone"));</p><p>`   `orderService.insert(order);</p><p>`   `for (OrderDetail orderDetail : order.getOrderDetails()) {</p><p>`      `orderDetail.setOrder(order);</p><p>`      `Product product = orderDetail.getProduct();</p><p>`      `product.setQuantity(product.getQuantity() - orderDetail.getQuantity());</p><p>`      `productService.update(product);</p><p>`      `orderDetailService.insert(orderDetail);</p><p>`   `}</p><p>`   `sm.sendEmail(toEmail, order);</p><p>`   `session.removeAttribute("order");</p><p>`   `request.getRequestDispatcher("/views/thankyou.jsp").forward(request, response);</p><p>}</p>|
| - |
# <a name="_toc152702028"></a>**3.1.7 Cập nhật thông tin cá nhân**
Khi người dùng chọn tên người dùng trên thanh công cụ 

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.023.png)



Người dùng sẽ được chỉnh sửa thông tin cá nhân của mình, nhưng không thể chỉnh sửa được Role hay trạng thái tài khoản.

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.024.png)
# <a name="_toc152702029"></a>**3.1.8 Xem thông tin đơn hàng**
Người dùng cũng sẽ xem được thông tin những đơn hàng mình đã đặt khi bấm vào nút view ở user orders (từ 2.1.7)

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.025.png)
# <a name="_toc152702030"></a>**3.2 Đối với người quản trị**
# <a name="_toc152702031"></a>**3.2.1 Quản lý người dùng**
`	`Admin được phép quản lý thông tin người dùng, xem thông tin người dùng tương tự mục 2.1.17, ngoài ra được chỉnh sửa thông tin người dùng.

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.026.png)

Đặc biệt có thể sửa đổi tình trạng tài khoản và vai trò của người dùng

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.027.png)

Code: 

|<p>protected void updateUser(HttpServletRequest request, HttpServletResponse response)</p><p>`      `throws ServletException, IOException {</p><p>`   `Upload ulp = new Upload();</p><p>`   `int id = Integer.*parseInt*(request.getParameter("id"));</p><p>`   `User user = userService.findById(User.class, id);</p><p>`   `user.setName(request.getParameter("name"));</p><p>`   `user.setBirthdate(request.getParameter("birthdate"));</p><p>`   `user.setPhoneNumber(request.getParameter("phoneNumber"));</p><p>`   `user.setPassword(request.getParameter("password"));</p><p>`   `switch (request.getParameter("gender")) {</p><p>`   `case "male":</p><p>`      `user.setGender(Gender.*MALE*);</p><p>`      `break;</p><p>`   `case "female":</p><p>`      `user.setGender(Gender.*FEMALE*);</p><p>`      `break;</p><p>`   `case "unknown":</p><p>`      `user.setGender(Gender.*UNKNOWN*);</p><p>`      `break;</p><p>`   `}</p><p>`   `switch (request.getParameter("role")) {</p><p>`   `case "admin":</p><p>`      `user.setRole(Role.*ADMIN*);</p><p>`      `break;</p><p>`   `case "user":</p><p>`      `user.setRole(Role.*USER*);</p><p>`      `break;</p><p>`   `}</p><p>`   `switch (request.getParameter("status")) {</p><p>`   `case "active":</p><p>`      `user.setStatus(Status.*ACTIVE*);</p><p>`      `break;</p><p>`   `case "inactive":</p><p>`      `user.setStatus(Status.*INACTIVE*);</p><p>`      `break;</p><p>`   `}</p><p>`   `Part filePart = request.getPart("image");</p><p>`   `if (filePart != null) {</p><p>`      `InputStream inputStream = filePart.getInputStream();</p><p>`      `byte[] imageBytes = inputStream.readAllBytes();</p><p>`      `String imageData = ulp.byteArrayToImageData(imageBytes);</p><p>`      `if (imageBytes.length > 0) {</p><p>`         `user.setImage(imageData);</p><p>`      `}</p><p>`   `}</p><p>`   `userService.update(user);</p><p>`   `response.sendRedirect(request.getContextPath() + "/listUser");</p><p>}</p><p></p><p>protected void deleteUser(HttpServletRequest request, HttpServletResponse response)</p><p>`      `throws ServletException, IOException {</p><p>`   `int id = Integer.*parseInt*(request.getParameter("id"));</p><p>`   `userService.delete(User.class, id);</p><p>`   `response.sendRedirect("listUser");</p><p>}</p><p></p>|
| :- |
# <a name="_toc152702032"></a>**3.2.2 Quản lý thương hiệu**
`	`Quản lý sản phẩm tương tự như quản lý user, cho phép thêm, sửa và xóa (nếu không ràng buộc tới bảng khác).![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.028.png)
**

# <a name="_toc152702033"></a>**3.2.3 Quản lý sản phẩm**
Quản lý tương tự như quản lý User, cho phép thêm, sửa và xóa (nếu không có ràng buộc).

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.029.png)
# <a name="_toc152702034"></a>**3.2.4 Quản lý đơn đặt hàng**
**	Cho phép admin xem được tất cả các đơn hàng đã được khách hàng đặt.

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.030.png)
**

# <a name="_toc152702035"></a>**CHƯƠNG 3: KẾT LUẬN**
# <a name="_toc152702036"></a>**1. Kết quả đạt được** 
Hoàn thành mọi chức năng cơ bản của vai trò 

Admin: 

- Thêm, xóa, sửa người dùng
- Thêm, xóa, sửa sản phẩm
- Thêm, xóa, sửa thương hiệu
- Xem order

User:

- Đăng ký, đăng nhập, lưu cart 
- Mua hàng và tiến hành thanh toán
- Cho phép lưu cart theo cả 2 phiên bản: session và cart ở database (bản phát triển).
- Hoàn thành triển khai hosting Web và Database
# <a name="_toc152702037"></a>**2. Phân công công việc**
**Giao diện:** Trọng, Trung

**Model:** Trọng, Trung

**DAO:** Trọng, Trung

**Controller:**

|Chức năng|Người thực hiện|
| :-: | :-: |
|Register|Trọng|
|Login|Trọng|
|Cart, LineItem (bản phát triển)|Trọng, Trung|
|User|Trung|
|Product|Trung|
|Home|Trọng, Trung|
|Order, OrderDetail|Trọng, Trung|
|Checkout|Trọng, Trung|

# <a name="_toc152702038"></a>**3. Hạn chế** 
`	`Chưa xử lý được phần Cart chọn được từng LineItem theo kiểu checkbox (bản phát triển), phần này chắc chắn sẽ làm được, nhưng trong phạm vi thời gian hiện tại, nhóm đã thực hiện hết sức mình.
# <a name="_toc152702039"></a>**4. Hướng phát triển**
# <a name="_toc152702040"></a>**4.1 Class Diagram**
![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.031.png)
# <a name="_toc152702041"></a>**4.2 Thay đổi (so với bản đã triển khai trên hosting)**
`	`Thay đổi chính cũng là lớn nhất là ảnh hưởng đến giỏ hàng với việc lưu Cart lên database, đồng thời vẫn xử lý được Order (hiểu là giỏ hàng ở bản cũ) tức là phiên bản phát triển hơn của Order ở bản cũ bằng cách thêm 2 thực thể mới là Cart và LineItem.

`	`Với Cart chức năng chính ở đây chính là chỉ lưu trữ những đơn hàng, và sau khi bấm thanh toán, LineItem ở giỏ sẽ mất đi và nó sẽ được chuyển thành OrderDetail và lưu hết vào Order.

**Khi người dùng chưa đăng nhập**

Xử lý lưu session như bản cũ

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.032.png)

**Khi người dùng đăng nhậ**p

Sẽ lấy dữ liệu cart từ database người dùng xuống, lưu những thông tin người dùng đã lưu ở cart

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.033.png)

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.034.png)![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.035.png)

**Vậy câu hỏi là nếu người dùng đăng nhập lần đầu thì sao?**

`	`Thì nhóm đã xử lý lấy cart ở session người dùng đã chọn lúc chưa đăng nhập làm giỏ hàng mới luôn cho người dùng → người dùng không phải mất thời gian chọn lại

=> **Đem lại trải nghiệm tốt cho người dùng**

Đây là giao diện người dùng chưa đăng nhập và giỏ hàng gồm 3 Iphone 14 và 1 Iphone 15, 700$

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.036.png)

Người dùng mới tiến hành đăng ký và đăng nhập

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.037.png)

Đăng nhập vào lập tức cart của session lưu cho người dùng luôn.

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.038.png)

![](/images/Aspose.Words.1d06b9f8-cdd0-4bed-94b3-a2f8ef703c1c.039.png)
2

