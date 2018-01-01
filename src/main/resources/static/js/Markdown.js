var testEditor;
testEditor=$(function() {
    editormd("test-editormd", {
        width   : "100%",
        height  : 340,
        codeFold : true,
        syncScrolling : "single",
        //你的lib目录的路径
        path    : "/editormd/lib/",
        imageUpload: false,//关闭图片上传功能
        emoji: false,
        taskList: true,
        tocm: true,         // Using [TOCM]
        tex: true,                   // 开启科学公式TeX语言支持，默认关闭
        flowChart: true,             // 开启流程图支持，默认关闭
        sequenceDiagram: true,       // 开启时序/序列图支持，默认关闭,
        saveHTMLToTextarea : true
    });
});