package presentacio.views;

import presentacio.Constants;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;

public class RankingView extends JPanel {

    JList listRanking;
    JButton bBackR;

    public RankingView() {

        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JPanel panel = new JPanel();

        panel.setBackground(new Color(240, 240, 240));
        add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        Component verticalStrut = Box.createVerticalStrut(20);
        panel.add(verticalStrut);

        ImageIcon imageUser = new ImageIcon(getClass().getResource("../../assets/img/Logo_Kajugo.png"));
        imageUser = scaleImage(imageUser, 128, 128);
        JLabel lblImage = new JLabel(imageUser);
        lblImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblImage);

        Component verticalStrut_1 = Box.createVerticalStrut(30);
        panel.add(verticalStrut_1);

        JPanel panel_0 = new JPanel();
        FlowLayout flowLayout0 = (FlowLayout) panel_0.getLayout();
        flowLayout0.setAlignment(FlowLayout.CENTER);
        panel.add(panel_0);

        JLabel lblNewLabel = new JLabel(Constants.RANKING);
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setForeground(SystemColor.activeCaption);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 33));
        panel_0.add(lblNewLabel);

        Component verticalStrut_0 = Box.createVerticalStrut(30);
        panel.add(verticalStrut_0);

        JPanel pareLlistes = new JPanel();
        pareLlistes.setLayout(new BorderLayout(0, 0));
        panel.add(pareLlistes);

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new TitledBorder(null, Constants.RANKING, TitledBorder.RIGHT, TitledBorder.TOP, null, null));
        pareLlistes.add(panel_4, BorderLayout.WEST);
        panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

        listRanking = new JList(); //data has type Object[]
        listRanking.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listRanking.setLayoutOrientation(JList.VERTICAL);
        listRanking.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane(listRanking);
        listScroller.setPreferredSize(new Dimension(250, 80));
        panel_4.add(listScroller);

        Component verticalStrut_4 = Box.createVerticalStrut(30);
        panel.add(verticalStrut_4);

        JPanel panel_2 = new JPanel();
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
        panel.add(panel_2);

        bBackR = new JButton(Constants.BACK);
        bBackR.setMinimumSize(new Dimension(200, 25));
        panel_2.add(bBackR);

    }

    private ImageIcon scaleImage(ImageIcon imageIcon, int width, int heigth) {
        Image image = imageIcon.getImage();                                             // transform it
        Image newimg = image.getScaledInstance(width, heigth, Image.SCALE_SMOOTH);     // scale it the smooth way
        return new ImageIcon(newimg);
    }

    public JList getListRanking() {
        return listRanking;
    }

    public JButton getbBackR() {
        return bBackR;
    }

    public void updateRankingList(List<String> ranking){
        listRanking.setListData(ranking.toArray());
    }
}
