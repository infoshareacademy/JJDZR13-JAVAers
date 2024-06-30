function ButtonsEnable(id){
    //window.alert(id);
    //var identifier1 = `alertID_${id}`;
    var identifier2 = `currCode_${id}`;
    var identifier3 = `HL_${id}`;
    var identifier4 = `course_${id}`;
    var identifier5 = `save_${id}`;
    console.log("identifier1 = "+identifier2);
    //document.getElementById(identifier1).disabled = false;

    document.getElementById(identifier2).disabled = false;
    document.getElementById(identifier3).disabled = false;
    document.getElementById(identifier4).disabled = false;
    //document.getElementById(identifier5).disabled = false;

// Disable the button
    const button = document.getElementById(identifier5);
    button.disabled = false;

    //window.alert(identifier);
}

function Confirm(message) {
    if (!window.confirm(message)) event.preventDefault();
}
function ConfirmDel(currCode, relation, value) {
    var message="Alert " + currCode + relation==='true' ?' > ':' < ' + value + "is going to be removed. Do you confirm?";
    if (!window.confirm(message)) event.preventDefault();
}