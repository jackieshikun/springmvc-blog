$(document).ready(function() {

    $("#confirm").change(function(){
        var p1 = $("#password").val();
        var p2 = $("#confirm").val();
        if(p1 != p2){
            $("#msg").show();
            $("#submit").prop("disabled",true);
        }else{
            $("#msg").hide();
            var agree = $("#agree").prop('checked');
            if(agree == true)
                $("#submit").prop("disabled",false);
            else
                $("#submit").prop("disabled",true);
        }
    });
    $("#agree").change(function(){
        var val = $("#agree").prop('checked');
        if(val == true){
            var p1 = $("#password").val();
            var p2 = $("#confirm").val();
            if(p1 != p2){
                $("#submit").prop("disabled",true);
            }else{
                $("#submit").prop("disabled",false);
            }
        }else{
            $("#submit").prop("disabled",true);
        }

    });

    $("input[type='password'][data-eye]").each(function(i) {
        var $this = $(this);

        $this.wrap($("<div/>", {
            style: 'position:relative'
        }));
        $this.css({
            paddingRight: 60
        });
        $this.after($("<div/>", {
            html: 'Show',
            class: 'btn btn-primary btn-sm',
            id: 'passeye-toggle-'+i,
            style: 'position:absolute;right:10px;top:50%;transform:translate(0,-50%);-webkit-transform:translate(0,-50%);-o-transform:translate(0,-50%);padding: 2px 7px;font-size:12px;cursor:pointer;'
        }));
        $this.after($("<input/>", {
            type: 'hidden',
            id: 'passeye-' + i
        }));
        $this.on("keyup paste", function() {
            $("#passeye-"+i).val($(this).val());
        });
        $("#passeye-toggle-"+i).on("click", function() {
            if($this.hasClass("show")) {
                $this.attr('type', 'password');
                $this.removeClass("show");
                $(this).removeClass("btn-outline-primary");
            }else{
                $this.attr('type', 'text');
                $this.val($("#passeye-"+i).val());
                $this.addClass("show");
                $(this).addClass("btn-outline-primary");
            }
        });
    });
});
