<script src="${Session.BASE_URL}/lying/layui/layui.js"></script>
<script src="${Session.BASE_URL}plugins/jquery-1.11.0.min.js"></script>
<script>
    var permission = new Array();
    $(function () {
        <#list menuPermission as permission>
            permission.push(${permission.id});
        </#list>
        reloadPermission();
    });
    function reloadPermission() {
        for(var i = 0 ; i < permission.length ; i++){
            if(permission[i] == 1){
                $("button[permission=add]").each(function () {
                    $(this).show();
                });
            }else if(permission[i] == 2){
                $("button[permission=edit]").each(function () {
                    $(this).show();
                });
            }else if(permission[i] == 3){
                $("button[permission=delete]").each(function () {
                    $(this).show();
                });
            }else if(permission[i] == 4){
                $("button[permission=export]").each(function () {
                    $(this).show();
                });
            }else if(permission[i] == 5){
                $("button[permission=import]").each(function () {
                    $(this).show();
                });
            }
        }
    }

</script>
