<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>

<!-- Block content - Đục lỗ trên giao diện bố cục chung, đặt tên là `content` -->
<div class="container mt-4">
    <form class="needs-validation" name="frmthanhtoan" method="post" action="<c:url value='/checkout'/>" onsubmit="return submitOrder()">
        <input type="hidden" name="kh_tendangnhap" value="dnpcuong">

        <div class="row">
            <div class="col-md-8 order-md-1">
                <h4 class="mb-3" style="color: #0000BB;">Customer's information</h4>

                <div class="row">
                    <div class="col-md-6">
                        <label for="kh_ten">Name</label>
                        <input type="text" class="form-control" name="kh_ten" required>
                        <div class="invalid-feedback">
                            Please enter your name.
                        </div>
                    </div>

                    <div class="col-md-6">
                        <label for="kh_diachi">Phone</label>
                        <input type="text" class="form-control" name="kh_diachi" required>
                        <div class="invalid-feedback">
                            Please enter your phone number.
                        </div>
                    </div>
                    <div class="col-md-12">
                        <label for="kh_dienthoai">Address</label>
                        <input type="text" class="form-control" name="kh_dienthoai" required>
                        <div class="invalid-feedback">
                            Please enter your address.
                        </div>
                    </div>
                    <div class="col-md-12">
                        <label for="kh_email">Email</label>
                        <input type="text" class="form-control" name="kh_email" required>
                        <div class="invalid-feedback">
                            Please enter your email address.
                        </div>
                    </div>
                </div>
                <hr class="mb-6">
                <div class="row">
						<div class="col">
							<form method="post">
									
										<a href="<c:url value='/cart-checkout'/>" class="btn btn-success" type="button" onclick="submitOrder()" >
										<i class="fa fa-shopping-cart" aria-hidden="true"  ></i> Order</a>
							</form>
						</div>
				 </div>
					<label class="form-labal" style="width: 100px"></label>

                <div style="margin-top: 40px;"></div>
            </div>

            <!-- Phương thức thanh toán bên phải -->
            <div class="col-md-90" style="margin-right: 30px;">
                <h4 class="mb-3" style="color: #0000BB;">Payment Method</h4>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="paymentCOD" name="paymentMethod" value="COD" onclick="togglePaymentFields('codFields')">
                    <label class="form-check-label" for="paymentCOD">Cash on Delivery</label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="paymentOnline" name="paymentMethod" value="Online" onclick="togglePaymentFields('onlineFields')">
                    <label class="form-check-label" for="paymentOnline">Online Payment</label>
                </div>
                <div class="invalid-feedback" id="paymentError">
                    Please select a payment method.
                </div>

                <!-- Fields for Cash on Delivery -->
                <div id="codFields">
                    <!-- Include fields specific to Cash on Delivery if needed -->
                </div>

                <!-- Fields for Online Payment 
                <div id="onlineFields" style="display: none;">
                    <div class="form-group">
                        <label for="bank">Bank</label>
                        <select class="form-control" id="bank" name="bank">
                            <option value="sacombank">Sacombank</option>
                            <option value="viettinbank">Viettinbank</option>
                            <option value="acb">AC Bank</option>
                            <option value="bidv">BIDV</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="cardNumber">Card Number</label>
                        <input type="text" class="form-control" id="cardNumber" name="cardNumber">
                    </div>
                    
                    <input type="hidden" name="balance" id="balance" value="${user.wallet}">

                    
                </div>
            </div>  -->
        </form>
    </div>
</div>

<script>







    
function submitOrder() {
    // Kiểm tra xem tất cả các trường thông tin đã được điền đầy đủ chưa
    var name = document.forms['frmthanhtoan']['kh_ten'].value;
    var phone = document.forms['frmthanhtoan']['kh_diachi'].value;
    var address = document.forms['frmthanhtoan']['kh_dienthoai'].value;
    var email = document.forms['frmthanhtoan']['kh_email'].value;
    var paymentMethod = document.forms['frmthanhtoan']['paymentMethod'].value;

    if (name === '' || phone === '' || address === '' || email === '' || paymentMethod === undefined) {
        alert('Vui lòng điền đầy đủ thông tin khách hàng và chọn phương thức thanh toán.');
        return false;
    }

    // Kiểm tra số dư tài khoản có đủ để thanh toán hay không
    // Trong Servlet hoặc Controller

    // Xử lý logic thanh toán ở đây (gửi dữ liệu đến server nếu cần)

    // Hiển thị chatbox "thanh toán thành công"
    alert('Thanh toán thành công');
    
    // resetCart();

    // Quay về trang home
    // window.location.replace('/GundamStore/home');

    // Trả về false để ngăn form gửi đi và trang được chuyển hướng bởi JavaScript
    return false;
}

   

</script>
<!-- End block content -->