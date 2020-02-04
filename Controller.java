package sample;

import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;


public class Controller {
    public TextField txfSource;
    public ImageView poubTarget;


    public void txfSourceDragDetected(MouseEvent mouseEvent) {
        Dragboard db = txfSource.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        if(txfSource.getText().isEmpty()) {
            content.putString(txfSource.getText());
            db.setContent(content);
        }
    }

    public void poubTargetDragDropped(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY);
    }

    public void poubTargetDragOver(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        txfSource.setText(db.getString());
        txfSource.clear();
    }
}
