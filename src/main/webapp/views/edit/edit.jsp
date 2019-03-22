<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../common/edit-md-header.jsp" />

<style>

    .a-radio{
        display: none;
    }
    .b-radio{
        display: inline-block;
        border:1px solid #ccc;
        width:16px;
        height: 16px;
        border-radius:2px;
        vertical-align: middle;
        margin-right: 5px;
        position: relative;
    }
    .b-radio:before{
        content: '';
        font-size: 0;
        width: 10px;
        height: 10px;
        background: rgb(143, 188, 238);
        position: absolute;
        left:50%;
        top:50%;
        margin-left: -5px;
        margin-top: -5px;
        border-radius: 2px;
        display: none;
    }
    .a-radio:checked~.b-radio:before{
        display: block;
    }


</style>

<body class="sidebar-fixed header-fixed sidebar-hidden">

    <form id="form-data" enctype="multipart/form-data">
    <div id="header">

        <div class="card-body">

        <div class="col-md-12">
        <div class="row mt-3">
            <div class="col-md-8">
                <div class="form-group">
                    <input name="title" id="title" class="form-control" placeholder="请输入标题">
                </div>
            </div>

            <div class="col-md-4">
                <button id="submit_btn" class="btn btn-primary" >发布文章</button>
            </div>
        </div>
            <div class="row mt-3">
                <div class="col-md-8">
                    <div class="form-group">
                        <input id="outline" name="outline" class="form-control" placeholder="请输入文章简介">
                    </div>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-8">
                    <div class="form-group">
                        <label>
                            <input type="radio" name="theme" id="theme1" value="0" class="a-radio" checked>
                            <span class="b-radio"></span>主题1
                        </label>
                        <label>
                            <input type="radio" name="theme" id="theme2" value="1" class="a-radio">
                            <span class="b-radio"></span>主题2
                        </label>
                    </div>
                </div>
            </div>

            <div class="row mt-3">

                <div class="col-md-1">
                    <button id="upload_btn" class="btn btn-primary">上传图片</button>
                    <input type="file" name="file" onchange="previewImage(this)" style="display: none;" id="previewImg">
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                    <div id="preview">

                        <img id="imghead" style="display: none" border="0" src="img/photo_icon.png" width="50" height="50" >
                    </div>
                    </div>
                </div>

            </div>

        </div>
        </div>

    </div>
    </form>


    <script>
        //图片上传预览    IE是用了滤镜。

        $(function(){
            $("#upload_btn").click(function(){
                $('#previewImg').click();
                return false;
            });
        })

        function previewImage(file)
        {
            var MAXWIDTH  = 50;
            var MAXHEIGHT = 50;
            var div = document.getElementById('preview');
            if (file.files && file.files[0])
            {
                div.innerHTML ='<img id=imghead onclick=$("#previewImg").click()>';
                var img = document.getElementById('imghead');
                img.onload = function(){
                    var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                    img.width  =  rect.width;
                    img.height =  rect.height;
//                 img.style.marginLeft = rect.left+'px';
                    img.style.marginTop = rect.top+'px';
                }
                var reader = new FileReader();
                reader.onload = function(evt){img.src = evt.target.result;}
                reader.readAsDataURL(file.files[0]);
            }
            else //兼容IE
            {
                var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
                file.select();
                var src = document.selection.createRange().text;
                div.innerHTML = '<img id=imghead>';
                var img = document.getElementById('imghead');
                img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
                var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
                div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
            }

            $("#imghead").show();

        }
        function clacImgZoomParam( maxWidth, maxHeight, width, height ){
            var param = {top:0, left:0, width:width, height:height};
            if( width>maxWidth || height>maxHeight ){
                rateWidth = width / maxWidth;
                rateHeight = height / maxHeight;

                if( rateWidth > rateHeight ){
                    param.width =  maxWidth;
                    param.height = Math.round(height / rateWidth);
                }else{
                    param.width = Math.round(width / rateHeight);
                    param.height = maxHeight;
                }
            }
            param.left = Math.round((maxWidth - param.width) / 2);
            param.top = Math.round((maxHeight - param.height) / 2);
            return param;
        }
    </script>

    <!--
    <div class="btns">
        <button id="goto-line-btn">Goto line 90</button>
        <button id="show-btn">Show editor</button>
        <button id="hide-btn">Hide editor</button>
        <button id="get-md-btn">Get Markdown</button>
        <button id="get-html-btn">Get HTML</button>
        <button id="watch-btn">Watch</button>
        <button id="unwatch-btn">Unwatch</button>
        <button id="preview-btn">Preview HTML (Press Shift + ESC cancel)</button>
        <button id="fullscreen-btn">Fullscreen (Press ESC cancel)</button>
        <button id="show-toolbar-btn">Show toolbar</button>
        <button id="close-toolbar-btn">Hide toolbar</button>
        <button id="toc-menu-btn">ToC Dropdown menu</button>
        <button id="toc-default-btn">ToC default</button>
    </div>
    -->
    <div id="test-editormd"></div>


</body>



<script type="text/javascript">


    function onbeforeunload_handler(){
        var warning="确认退出?";
        return warning;
    }

    function onunload_handler(){
        var warning="谢谢光临";
        alert(warning);
    }

    var testEditor;
    $(function() {

        window.onbeforeunload = onbeforeunload_handler;
        window.onunload = onunload_handler;
        var heidht = $(document).height() - 20;
        // var card_body_heidht = $(".card-body").outerHeight();
        // heidht -= card_body_heidht;
        $.ajax({
            url:"/test",
            type:"get",
            success:function(md){
                testEditor = editormd("test-editormd", {
                    width: "96%",
                    height: heidht,
                    path : '/common/plugin/edit.md/lib/',
                    theme : "dark",
                    previewTheme : "dark",
                    editorTheme : "pastel-on-dark",
                    markdown : md,
                    codeFold : true,
                    //syncScrolling : false,
                    saveHTMLToTextarea : true,    // 保存 HTML 到 Textarea
                    searchReplace : true,
                    //watch : false,                // 关闭实时预览
                    htmlDecode : "style,script,iframe|on*",            // 开启 HTML 标签解析，为了安全性，默认不开启
                    //toolbar  : false,             //关闭工具栏
                    //previewCodeHighlight : false, // 关闭预览 HTML 的代码块高亮，默认开启
                    emoji : true,
                    taskList : true,
                    tocm : true,         // Using [TOCM]
                    tex : true,                   // 开启科学公式TeX语言支持，默认关闭
                    flowChart : true,             // 开启流程图支持，默认关闭
                    sequenceDiagram : true,       // 开启时序/序列图支持，默认关闭,
                    //dialogLockScreen : false,   // 设置弹出层对话框不锁屏，全局通用，默认为true
                    //dialogShowMask : false,     // 设置弹出层对话框显示透明遮罩层，全局通用，默认为true
                    //dialogDraggable : false,    // 设置弹出层对话框不可拖动，全局通用，默认为true
                    //dialogMaskOpacity : 0.4,    // 设置透明遮罩层的透明度，全局通用，默认值为0.1
                    //dialogMaskBgColor : "#000", // 设置透明遮罩层的背景颜色，全局通用，默认为#fff
                    imageUpload : true,
                    imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
                    imageUploadURL : "/edit/upload",
                    onload : function() {
                        console.log('onload', this);
                        //this.fullscreen();
                        //this.unwatch();
                        //this.watch().fullscreen();

                        //this.setMarkdown("#PHP");
                        //this.width("100%");
                        //this.height(480);
                        //this.resize("100%", 640);
                    }
                })
            }
        });


        // $("#goto-line-btn").bind("click", function(){
        //     testEditor.gotoLine(90);
        // });
        //
        // $("#show-btn").bind('click', function(){
        //     testEditor.show();
        // });
        //
        // $("#hide-btn").bind('click', function(){
        //     testEditor.hide();
        // });
        //
        // $("#get-md-btn").bind('click', function(){
        //     alert(testEditor.getMarkdown());
        // });
        //
        // $("#get-html-btn").bind('click', function() {
        //     alert(testEditor.getHTML());
        // });
        //
        // $("#watch-btn").bind('click', function() {
        //     testEditor.watch();
        // });
        //
        // $("#unwatch-btn").bind('click', function() {
        //     testEditor.unwatch();
        // });
        //
        // $("#preview-btn").bind('click', function() {
        //     testEditor.previewing();
        // });
        //
        // $("#fullscreen-btn").bind('click', function() {
        //     testEditor.fullscreen();
        // });
        //
        // $("#show-toolbar-btn").bind('click', function() {
        //     testEditor.showToolbar();
        // });
        //
        // $("#close-toolbar-btn").bind('click', function() {
        //     testEditor.hideToolbar();
        // });
        //
        // $("#toc-menu-btn").click(function(){
        //     testEditor.config({
        //         tocDropdown   : true,
        //         tocTitle      : "目录 Table of Contents",
        //     });
        // });
        //
        // $("#toc-default-btn").click(function() {
        //     testEditor.config("tocDropdown", false);
        // });

        $("#submit_btn").click(function(){
            var form_data = $("#form-data").serializeObject();
            var data = new FormData();
            data.append("file",$("#previewImg")[0].files[0]);
            data.append("title",form_data.title);
            data.append("outline",form_data.outline);
            data.append("theme",form_data.theme);
            data.append("markdown",testEditor.getMarkdown());
            data.append("content",testEditor.getHTML());
            $.ajax({
                url:"/edit",
                type:"POST",
                data:data,
                contentType: false,
                processData: false,
                success:function(result){
                    if(result.code == 1){
                        swal({
                            icon: "success",
                            title: "修改成功",
                            text:"点击'确定'按钮关闭当前页面",
                            confirmButtonText:"确认"
                        }).then(data => {
                            if(data == true){
                            window.onbeforeunload = null;
                            window.close();
                        }
                        });
                    } else {
                        swal({
                            title: "修改成功",
                            icon: "error"
                        });
                    }
                }
            })
            return false;
        });

    });
</script>

<jsp:include page="../common/footer.jsp" />
