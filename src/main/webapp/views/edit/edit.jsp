<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../common/edit-md-header.jsp" />

<body class="sidebar-fixed header-fixed sidebar-hidden">
    <div id="header">

        <div class="card-body">


        <div class="col-md-12">
        <div class="row mt-3">
            <div class="col-md-8">
                <div class="form-group">
                    <input id="placeholder-input" class="form-control" placeholder="请输入标题">
                </div>
            </div>

            <div class="col-md-4">
                <button class="btn btn-primary" >发布文章</button>
            </div>
        </div>
        </div>
        </div>

    </div>


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
        var card_body_heidht = $(".card-body").outerHeight();
        heidht -= card_body_heidht;
        $.ajax({
            url:"/test",
            type:"get",
            success:function(md){
                testEditor = editormd("test-editormd", {
                    width: "98%",
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
                    tocm            : true,         // Using [TOCM]
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
                    imageUploadURL : "./php/upload.php",
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


        $("#goto-line-btn").bind("click", function(){
            testEditor.gotoLine(90);
        });

        $("#show-btn").bind('click', function(){
            testEditor.show();
        });

        $("#hide-btn").bind('click', function(){
            testEditor.hide();
        });

        $("#get-md-btn").bind('click', function(){
            alert(testEditor.getMarkdown());
        });

        $("#get-html-btn").bind('click', function() {
            alert(testEditor.getHTML());
        });

        $("#watch-btn").bind('click', function() {
            testEditor.watch();
        });

        $("#unwatch-btn").bind('click', function() {
            testEditor.unwatch();
        });

        $("#preview-btn").bind('click', function() {
            testEditor.previewing();
        });

        $("#fullscreen-btn").bind('click', function() {
            testEditor.fullscreen();
        });

        $("#show-toolbar-btn").bind('click', function() {
            testEditor.showToolbar();
        });

        $("#close-toolbar-btn").bind('click', function() {
            testEditor.hideToolbar();
        });

        $("#toc-menu-btn").click(function(){
            testEditor.config({
                tocDropdown   : true,
                tocTitle      : "目录 Table of Contents",
            });
        });

        $("#toc-default-btn").click(function() {
            testEditor.config("tocDropdown", false);
        });
    });
</script>
<jsp:include page="../common/footer.jsp" />
