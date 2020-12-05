$(document.getElementById("MeuDiv")).ready(function(){
  $("#esconder").click(function(){
    $(document.getElementById("MeuDiv")).hide();
  });
  $("#exibir").click(function(){
    $(document.getElementById("MeuDiv")).show();
  });
});
