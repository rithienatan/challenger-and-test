/**
 * @author Rithie Natan Carvalhaes Prado
 * @email rithienatan@gmail.com
 * @version 1.0.0
 * 
 */

SELECT Nome
FROM ALUNO, DICIPLINA
WHERE ALUNO.Id = DICIPLINA.Id OR (ALUNO.Id = ALUNO_DICIPLINA.Id_aluno)