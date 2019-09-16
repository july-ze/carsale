<%--
  Created by IntelliJ IDEA.
  User: sasa
  Date: 2019/9/15
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

</head>
<body>

<!-- 客户付款确认模式窗口 -->
<div class="modal fade" id="customerPayment">
    <div class="modal-dialog">
        <div class="modal-content message_align">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span></button>
                <h4 class="modal-title">提示信息！！！</h4>
            </div>
            <div class="modal-body">
                <h1 style="color:red; text-alien:center;">您确认客户已支付款项吗？</h1>
                <h3>总计为：<span id="totalPrice" style="font:1px red bold;text-alien:center;"></span>元</h3>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <a id="delModelSubmit" v="" empId="${emp.empId}" class="btn btn-danger"
                   data-dismiss="modal">确定</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>
