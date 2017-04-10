function reorderDatatable() {
    $('.dataTables_filter').addClass("pull-left");
    $('.dt-buttons').addClass("pull-right");
    $('.dt-buttons').addClass("hidden-xs");
    $('.dt-buttons').addClass("hidden-sm");
    $('.dataTables_length').addClass("pull-left");
    $('.dataTables_length').addClass("hidden-sm");
    $('.dataTables_length').addClass("hidden-xs");
    $('.dataTables_length').css("padding-left", "10px");
    
    // Contoh Penggunaan
    //    $('#example2').DataTable({
    //        dom: 'fBlrtip',
    //        responsive: true,
    //        buttons: [
    //            'excel', 'pdf', 'copy'
    //        ],
    //        initComplete: function () {
    //            reorderDatatable();
    //        }
    //    });
}