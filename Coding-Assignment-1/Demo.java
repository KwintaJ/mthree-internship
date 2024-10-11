//Question3

public class Demo
{
    void perform(Game g)
    {
        g.play();
    }

    public static void main(String[] args)
    {
        Demo computer = new Demo();
        Cricket game1 = new Cricket();
        FootBall game2 = new FootBall();
        Tennis game3 = new Tennis();

        computer.perform(game1);
        computer.perform(game2);
        computer.perform(game3);
    }
}

interface Game
{
    public void play();
}

class Cricket implements Game
{
    @Override
    public void play()
    {
        System.out.println("playing game of cricket");
    }
}

class FootBall implements Game
{
    @Override
    public void play()
    {
        System.out.println("playing game of football");
    }
}

class Tennis implements Game
{
    @Override
    public void play()
    {
        System.out.println("playing game of tennis");
    }
}
