<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="formUrl" value="/admin-guideline-listen-edit.html"/>
<html>
<head>
    <title><fmt:message key="label.guideline.listen.edit" bundle="${lang}"/></title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#"><fmt:message key="label.home" bundle="${lang}"/></a>
                </li>
                <li class="active"><fmt:message key="label.guideline.listen.edit" bundle="${lang}"/></li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
<%--                    <div class="form-group">--%>
<%--                        <div class="col-sm-12">--%>
<%--                            <h2>HE</h2>--%>
<%--                            <p>hahahahaa</p>--%>
<%--                            <p>hahahahaa</p>--%>
<%--                            <p class="thide">hahahahaa</p>--%>
<%--                            <button id="btn">Click me</button>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <div class="col-sm-12">--%>
<%--                            <input  type="text", id="value", value="nachiluong"/>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <div class="col-sm-12">--%>
<%--                            <p id="ppp">Nothing</p>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <div class="col-sm-12">--%>
<%--                            <button id="btnValue" onclick="usingValAction()">Click Value</button>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                         <div class="col-sm-12">--%>
<%--                             <input type="checkbox" id="checkbox" checked/>--%>
<%--                         </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <div class="col-sm-12">--%>
<%--                            <p style="color: red" id="cssMethod1">hahahahahaha</p>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <div class="col-sm-12">--%>
<%--                            <button id="cssMethod">Change color</button>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <input type="checkbox" id="sex" onchange="change()"/>
                            <p id="textSex"></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script >
    $(document).ready(function (){
        hideAllWhenButton();
        // usingValAction();
        demoCssMethod()
        change()
    });
    function hideAllWhenButton(){
        $("#btn").click(function (){
           $(".thide").hide();
        });
    }
    function usingValAction(){
        // $('#btnValue').click(function (){
            var value=$('#value').val();
            $('#ppp').html(value);
        // });
    }
    function demoCssMethod() {
        $('#cssMethod').click(function () {
            $('#cssMethod1').css("color", "blue");
        });
    }
    function change(){
        // $('#sex').on('change', function ()){}
        if($('#sex').prop('checked')==true){
            $('#textSex').html('<h1>Male</h1>');
        }
        else {
            $('#textSex').html('<h1>Female</h1>');
        }
    }
</script>
</body>
</html>