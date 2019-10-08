package paint;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.io.BufferedWriter;
import java.io.IOException;

public class MyRhombus implements Class2D {
  private Polygon rectangle;
  private Color lineColor;
  private Color fillColor = null;

  public void makeObject(Point startDrag, Point endDrag) {
    setLineColor(GUI.selectColor);
    double startX = startDrag.x;
    double startY = startDrag.y;
    double endX = endDrag.x;
    double endY = endDrag.y;
    double distanceX = endX - startX;
    double distanceY = (endY - startY);
    double length = Math.hypot(distanceX, distanceY);
    double centerX = startX + distanceX / 2;
    double centerY = startY + distanceY / 2;
    double asine = Math.asin(distanceY / length);
    double acosine = Math.acos(distanceX / length);

    double sideProportion = 0.5;

    // pls send help
    int[] xs = {
        (int) startX,
        (int) (centerX + length * sideProportion * Math.sin(asine + 1.41) / 2),
        (int) endX,
        (int) (centerX + length * sideProportion * Math.sin(asine - 1.41) / 2)
    };
    int[] ys = {
        (int) startY,
        (int) (centerY + length * sideProportion * Math.cos(acosine + 1.41) / 2),
        (int) endY,
        (int) (centerY + length * sideProportion * Math.cos(acosine - 1.41) / 2)
    };

    rectangle = new Polygon(xs, ys, 4);
    this.setRectangle(rectangle);
  }

  public void setRectangle(Polygon rectangle) {
    this.rectangle = rectangle;
  }

  public Polygon getRectangle() {
    return this.rectangle;
  }

  public void fill(Color c) {
    this.setColor(c);
  }

  public Color getColor() {
    return this.fillColor;
  }

  public void setColor(Color color) {
    this.fillColor = color;
  }

  public Color getLineColor() {
    return this.lineColor;
  }

  public void setLineColor(Color lineColor) {
    this.lineColor = lineColor;
  }

  @Override
  public boolean contains(Point p) {
    return getRectangle().contains(p);
  }

  @Override
  public void move(Point startDrag, Point endDrag) {
    int[] xs = {0, 0, 0, 0};
    int[] ys = {0, 0, 0, 0};
    for (int k = 0; k < 4; k++) {
      xs[k] = this.getRectangle().xpoints[k] + endDrag.x - startDrag.x;
      ys[k] = this.getRectangle().ypoints[k] + endDrag.y - startDrag.y;
    }
    this.setRectangle(new Polygon(xs, ys, 4));
  }

  @Override
  public void writetoFile(BufferedWriter b) {
    try {
      b.write(getClass().getSimpleName() + ";");
      b.write(getRectangle().xpoints[0] + ";" + getRectangle().ypoints[0] + ";");
      b.write(getRectangle().xpoints[2] + ";" + getRectangle().ypoints[2] + ";");
      b.write(getLineColor().getRed() + ";" + getLineColor().getGreen() + ";" + getLineColor().getBlue() + ";");
      if (getColor() == null) {
        b.write("null" + ";" + "null" + ";" + "null");
      } else {
        b.write(getColor().getRed() + ";" + getColor().getGreen() + ";" + getColor().getBlue());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void draw(GraphicAdapter g) {
    if (getColor() == null) {
      g.getGraphicAdapter().setColor(getLineColor());
      g.getGraphicAdapter().drawPolygon(getRectangle());
    } else {
      g.getGraphicAdapter().setColor(getColor());
      g.getGraphicAdapter().fillPolygon(getRectangle());
    }
  }
}
