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
         $('.js-currency').maskMoney({allowNegative: true, thousands:'.', decimal:',', affixesStay: true});

         $('.js-atualizar-status').on('click', function (event) {
                event.preventDefault();
                var botaoReceber = $(event.currentTarget);
                var urlReceber = botaoReceber.attr('href');

                var response = $.ajax({
                    url: urlReceber,
                    type: "PUT"
                });
                response.done(function (e) {
                    var codigoTitulo = botaoReceber.data('codigo');
                    $('[data-role=' + codigoTitulo + ']').html('<span class="badge badge-success">' + e + '</span>');
                    botaoReceber.hide();
                });
                response.fail(function (e) {
                    console.log(e)
                });

         });
 });



