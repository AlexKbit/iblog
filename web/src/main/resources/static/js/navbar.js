
$(document).ready(function() {
    activeSelectTab();
})


function activeSelectTab() {
    var tabName = window.location.pathname.split('/')[1];
    if ($.inArray(tabName, ["posts", "library", "aboutMe"]) != -1) {
        $('#appTab_'+tabName).addClass('active')
    }

}