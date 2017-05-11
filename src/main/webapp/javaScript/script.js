$(document).ready(function () {
    $('#mainTable').DataTable();
});

// Modal Call Details Dialog
$(document).on('click', '.callDetails', function () {
    var callId = $(this).attr('rel');

    $.post("showCallIdAction", {callId: callId}, function (data) {

        var newRes = JSON.parse(data);
        var result = Object.keys(newRes).map(function (_) {
            return newRes[_];
        });

        $('#callDialog').modal('show');
        document.getElementById("callIdHeader").innerHTML = callId;
        $('#tableCallDialog').DataTable({
            searching: false,
            ordering: false,
            destroy: true,
            paging: false,
            scrollY: 400,
            data: result,
            columns: [
                {data: 'caller'},
                {data: 'eventName'},
                {data: 'receiver'},
                {data: 'recordDate'},
                {data: 'callId'}
            ]
        });
    });
});

//    Modal All Calls Dialog
$(document).on('click', '#caller', function () {
    var caller = $(this).attr('rel');

    $.post("showEventAction", {caller: caller}, function (data) {

        var newRes = JSON.parse(data);
        var result = Object.keys(newRes).map(function (_) {
            return newRes[_];
        });

        $('#allCalls').modal('show');
        document.getElementById("callerHeader").innerHTML = caller;
        $('#tableAllCalls').DataTable({
            searching: false,
            ordering: false,
            destroy: true,
            paging: false,
            scrollY: 400,
            data: result,
            columns: [
                {data: 'recordDate'},
                {data: 'talkDuration'},
                {data: 'receiver'},
                {data: 'callType'}
            ]
        });

    });
});



