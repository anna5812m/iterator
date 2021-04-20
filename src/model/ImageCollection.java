package model;

import javafx.scene.image.Image;

public class ImageCollection implements Aggregate {
    private String filetopic;
    private Image bi;

    public ImageCollection(String filetopic) {
        this.filetopic = filetopic;
    }

    @Override
    public Iterator getIterator() {
        return new ImageIterator();
    }

    private class ImageIterator implements Iterator {
        private int current = 0;

        @Override
        public boolean hasNext() {
            String filename="/Resourse//"+filetopic+(current+1)+".jpg";
            try {
                bi = new Image(filename);
                return true;

            } catch (Exception ex) {
                System.err.println
                        ("Неудалось загрузитькартинку! " + filename);
                ex.printStackTrace();
                return false;
            }
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                current= (current+1)%5;
                return bi;
            }
            return null;
        }

        @Override
        public Object preview() {
            return null;
        }
    }
}
