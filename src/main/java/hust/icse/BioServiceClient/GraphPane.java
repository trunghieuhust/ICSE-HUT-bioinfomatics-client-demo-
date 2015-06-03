package hust.icse.BioServiceClient;

import javax.swing.JPanel;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class GraphPane extends JPanel {
	private mxGraph graph;

	public GraphPane() {
		graph = new mxGraph();
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();

		try {
			Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 80,
					30);
			Object v2 = graph.insertVertex(parent, null, "World!", 240, 150,
					80, 30);
			graph.insertEdge(parent, null, "Edge", v1, v2);

		} finally {
			graph.getModel().endUpdate();
		}
		mxGraphComponent component = new mxGraphComponent(graph);
		add(component);
	}

	public void insertGraph() {
		graph.getModel().beginUpdate();
		
		graph.getModel().endUpdate();
	}
}
