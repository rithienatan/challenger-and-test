/**
 * @author Rithie Natan Carvalhaes Prado
 * @email rithienatan@gmail.com
 * @version 1.0.0
 * 
 */

class QuestaoI
{
    private QuestaoI instance;

    public QuestaoI getInstance()
    {
        if(instance == null)
        { instance = new QuestaoI(); }

        return instance;
    }
}