- import JFrame
- Constructor
## Spring layout
- each component position is based on two springs for each axis
- based on the distance between edges, not centre of size/gravity
- first component position is based off the top left corner
```java
SpringLayout layout = new SpringLayout();

layout.putConstraint(SpringLayout.WEST,this, 100, SpringLayout.WEST,labelTitle);
```

## Auto stop debugging when close window
```java
addWindowListener(new WindowAdapter() {  
    @Override  
    public void windowClosing(WindowEvent e) {  
        System.exit(0);  
    }});
```