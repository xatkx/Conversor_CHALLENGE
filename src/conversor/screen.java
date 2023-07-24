package conversor;

import java.awt.*;

public class screen {

    public int width;
    public int height;

    screen(){
        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension d = tool.getScreenSize();

        width = d.width;
        height = d.height;
    }
}
