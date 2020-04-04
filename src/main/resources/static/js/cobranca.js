 $('#delete-modals ').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var href = button.data('href')
        var codigoTitulo = button.data('codigo')
        var descricaoTitulo = button.data('descricao')

        var modal = $(this)
        modal.find('.btn-excluir').attr('href', href + '/' + codigoTitulo);
        modal.find('.modal-title').text( descricaoTitulo)
 });

 $(function () {
         $('[data-tog="tooltip"]').tooltip()
         $('.js-currency').maskMoney({prefix:'R$ ', allowNegative: true, thousands:'.', decimal:',', affixesStay: true});
 });



