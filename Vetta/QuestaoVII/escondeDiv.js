/**
 * @author Rithie Natan Carvalhaes Prado
 * @email rithienatan@gmail.com
 * @version 1.0.0
 * 
 */

$(document.getElementById("MeuDiv")).ready(function(){
  $("#esconder").click(function(){
    $(document.getElementById("MeuDiv")).hide();
  });
  $("#exibir").click(function(){
    $(document.getElementById("MeuDiv")).show();
  });
});
