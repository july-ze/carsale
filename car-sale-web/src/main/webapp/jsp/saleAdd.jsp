<%--
  Created by IntelliJ IDEA.
  User: sasa
  Date: 2019/9/15
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

</head>
<body>

<div class="col-md-6 col-sm-6 col-xs-6">
    <div class="x_panel">
        <div class="x_title">
            <h2> 销售登记 </h2>
            <ul class="nav navbar-right panel_toolbox">
                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                        <i class="fa fa-wrench"></i></a>
                </li>
                <li><a class="close-link"><i class="fa fa-close"></i></a>
                </li>
            </ul>
            <div class="clearfix"></div>
        </div>
        <div class="x_content">
            <br/>
            <form id="addCustomer" data-parsley-validate class="form-horizontal form-label-left"
                  action="${pageContext.request.contextPath}/sale/insertSale" method="post">
                <input type="hidden" name="saleType" value="1"/>
                <input type="hidden" name="adminEmpId" value="${employee.empId}"/>
                <input id="saleCompany" type="hidden" name="companyId" value="${employee.companyId}"/>

                <%--<div class="form-group">--%>
                    <%--<label class="control-label col-md-3 col-sm-3 col-xs-12">购车客户</label>--%>
                    <%--<div class="col-md-6 col-sm-6 col-xs-12">--%>
                        <%--<div class="input-group">--%>
                            <%--<input id="saleCustomerName" type="text"--%>
                                   <%--placeholder="输入电话查询" class="form-control">--%>
                            <%--<input id="saleCustomerId" name="customerId" type="hidden">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12">购车客户</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <select name="customerId" id="saleCustomerName" class="select2_single form-control"
                                tabindex="-1">
                            <option value="0">---选择公司客户---</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12">购置汽车</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <select name="carId" id="saleSelectBrand" class="select2_single form-control"
                                tabindex="-1">
                            <option value="0">---选择库存汽车---</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12">汽车车系</label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <div class="input-group">
                            <input id="saleCarSeries" type="text" class="form-control"
                                   readonly="readonly">
                            <input type="hidden" name="repertoryId" id="repertoryId"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12">汽车品牌</label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <div class="input-group">
                            <input id="saleCarBrand" type="text" class="form-control" readonly="readonly">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12">含税价格</label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <div class="input-group">
                            <input id="purchasePrice" name="purchasePrice" type="text" class="form-control"
                                   readonly="readonly">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12">销售价格</label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <div class="input-group">
                            <input id="saleCurPrice" name="saleCurprice" type="text" class="form-control">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12">销售人员</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <select name="empId" id="saleEmpId" class="select2_single form-control"
                                tabindex="-1">
                            <option value="0">---选择销售人员---</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12">购买数量
                        <span class="required">*</span>
                    </label>
                    <p id="saleNum" style="margin-bottom: 0px;border-left-width: 0px;padding-left: 130px;padding-top: 5px;">
                        one:
                        <input type="radio" class="flat" name="saleNum" value="1" checked="checked"/>
                    </p>
                </div>

                <div class="ln_solid"></div>
                <div class="form-group">
                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-4">
                        <button id="saleButtonSubmit" type="submit" class="btn btn-success">提交</button>
                        <button type="reset" class="btn btn-primary">重置</button>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>

</body>
</html>
