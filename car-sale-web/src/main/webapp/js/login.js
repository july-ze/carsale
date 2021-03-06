$(function () {
    /*获取工程名称*/
    var projectName = $('#projectName').attr('project');
    console.log(projectName);

    var but_login = $('#but_login');//登录按钮
    var CompanyName_login = $('#CompanyName_login');//公司名称
    var PositionName_login = $('#PositionName_login');//职务名称
    var EmpName_login = $('#EmpName_login');//员工名称
    var PhoneNumber_login = $('#PhoneNumber_login');//员工电话
    var Password_login = $('#Password_login');//密码

    /*电话正则表达式*/
    var telphonePar = /^1[3|4|5|7|8][0-9]{9}$/;

    /*同步验证用户信息*/
    $('#but_login').click(function () {
        console.log("同步验证用户信息");
        //各种框是空的情况
        if (0 == CompanyName_login.val()
            || 0 == (PositionName_login.val())
            || $.isEmptyObject(EmpName_login.val())
            || $.isEmptyObject(PhoneNumber_login.val())
            || $.isEmptyObject(Password_login.val())) {
            alert("输入框不能为空！");
        } else {
            var companyId = CompanyName_login.val();
            var positionName_login = PositionName_login.val();
            var empName = EmpName_login.val();
            var phoneNumber_login = PhoneNumber_login.val();
            var password_login = Password_login.val();

            /*var psw = $.md5(password_login);//md5加密*/

            /*发送post请求验证用户*/
            $.post(projectName + '/login/isLoginSuccess',
                {
                    companyId: companyId, positionId: positionName_login,
                    empName: empName, empPhone: phoneNumber_login, empPassword: password_login
                },
                function (data) {
                    var resultValue = data.resultLogin;
                    if ("false" == resultValue) {
                        alert("登录失败,请查证后重试！");
                        location.reload();
                    } else {
                        console.log("登录成功！");
                        location.href = projectName + '/login/goMain';
                    }
                }, "json");
        }
    });


    /*异步判断员工姓名是否正确*/
    $('#EmpName_login').blur(function () {
        var empName = $(this).val();
        console.log(empName);

        /*ajax获取查询的json数据*/
        $.getJSON(
            projectName + '/login/isExistEmpName',
            {empName: empName},
            function (json) {
                var resultName = json.resultName;
                if ("true" == resultName) {
                    //如果是true代表员工名称正确
                    EmpName_login.removeAttr("style");
                    //解除按钮禁止
                    but_login.attr('class', 'btn btn-default submit');
                } else {
                    //如果是false代表员工名称错误
                    EmpName_login.attr('style', 'border: red 2px solid');
                    //禁止提交按钮点击
                    but_login.attr('class', 'btn btn-danger disabled');
                }
            });
    });

    /*异步判断员工电话是否正确*/
    $('#PhoneNumber_login').blur(function () {
        var empPhone = $(this).val();
        var empName = $('#EmpName_login').val();
        var companyId = CompanyName_login.val();
        $.getJSON(
            projectName + '/login/isExistEmpPhone',
            {companyId: companyId, empName: empName, empPhone: empPhone},
            function (json) {
                var resultName = json.resultName;
                if ("true" == resultName) {
                    //如果是true代表员工电话正确
                    PhoneNumber_login.removeAttr("style");
                    //解除按钮禁止
                    but_login.attr('class', 'btn btn-default submit');
                } else {
                    //如果是false代表员工电话错误
                    PhoneNumber_login.attr('style', 'border: red 2px solid');
                    //禁止提交按钮点击
                    but_login.attr('class', 'btn btn-danger disabled');
                }
            });


    });

});