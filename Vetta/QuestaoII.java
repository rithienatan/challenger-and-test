/**
 * @author Rithie Natan Carvalhaes Prado
 * @email rithienatan@gmail.com
 * @version 1.0.0
 * 
 */

class QuestaoII
{
    private QuestaoII instance;

    public QuestaoII getInstance()
    {
        if(instance == null)
        { instance = new QuestaoII(); }

        return instance;
    }
}