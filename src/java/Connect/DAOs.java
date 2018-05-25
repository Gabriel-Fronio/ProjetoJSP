package Connect;


public class DAOs
{
    private static MeuPreparedStatement bd;

    
    static
    {
        try
        {
            DAOs.bd = new MeuPreparedStatement (
                      "com.microsoft.sqlserver.jdbc.SQLServerDriver",
                      "jdbc:sqlserver://regulus.cotuca.unicamp.br:1433;databasename=JSP1RB16166",
                      "JSP1RB16166", "JSP1RB16166");

        }
        catch (Exception erro)
        {
            System.out.println(erro);
        }
    }

    public static MeuPreparedStatement getBD ()
    {
        return DAOs.bd;
    }
}