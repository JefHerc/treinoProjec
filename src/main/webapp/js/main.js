function validarForm(){
    validarPaciente()
    validarExame()
    compararDatas()
    var validar = $('.to-check').hasClass('is-invalid');
    if (validar) {
        return false;
    } else {
        return true;
    }
}

function validarPaciente(){
    var paciente = $('#paciente');
    if (paciente.val().length < 1) 
        paciente.addClass("is-invalid");
}

function validarExame(){
    var exame = $('#exame');
    if (exame.val().length < 1) 
        exame.addClass("is-invalid");
}

$('.to-check').on('input', function(){
    $(this).removeClass("is-invalid");    
});

function compararDatas() {
    
    var dataInserida = Date.parse($('#data-exame').val());
    
    var hoje = new Date();
    if (isNaN(dataInserida) || dataInserida < hoje.getTime()) {
        $('#data-exame').addClass("is-invalid");
    }
  }

function confirmacaoDeletar(){
    confirm('Deseja realmente deletar este registro?');
}
  