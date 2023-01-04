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
    
    var infoInserida = $('#data-exame').val();
    var data = Date.parse(infoInserida);
    console.log('infoInserida' + infoInserida);
    console.log('convertida ' + data);
    var hoje = new Date();
    if (isNaN(data) || data < hoje.getTime()) {
        $('#data-exame').addClass("is-invalid");
    }
  }

function confirmacaoDeletar(){
    confirm('Deseja realmente deletar este registro?');
}
  