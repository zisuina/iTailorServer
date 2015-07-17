package resource.example;

import entity.Dog;
import util.BaseDAO;

import javax.servlet.http.HttpServlet;


public class DogServlet extends HttpServlet {
	private BaseDAO<Dog> baseDAO = new BaseDAO<Dog>();
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		doPost(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//
//		String action = request.getParameter("action");
//
//		if ("initAdd".equals(action)) {
//			initAdd(request, response);
//		} else if ("add".equals(action)) {
//			add(request, response);
//		} else if ("edit".equals(action)) {
//			edit(request, response);
//		} else if ("save".equals(action)) {
//			save(request, response);
//		} else if ("view".equals(action)) {
//			view(request, response);
//		} else if ("list".equals(action)) {
//			list(request, response);
//		} else if ("delete".equals(action)) {
//			delete(request, response);
//		} else {
//			list(request, response);
//		}
//	}
//
//	protected void initAdd(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//
//		List<Dog> DogList = baseDAO.list(" select c from Dog c ");
//
//		request.setAttribute("DogList", DogList);
//
//		request.getRequestDispatcher("/addDog.jsp").forward(request, response);
//	}
//
//	protected void add(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		int motherId = Integer.parseInt(request.getParameter("motherId"));
//		String name = request.getParameter("name");
//		String description = request.getParameter("description");
//
//		Dog mother = baseDAO.find(Dog.class, motherId);
//
//		Dog Dog = new Dog();
//		Dog.setName(name);
//		Dog.setMother(mother);
//		Dog.setDescription(description);
//		Dog.setCreateDate(new Date());
//
//		baseDAO.create(Dog);
//
//		request.setAttribute("msg", "ADD '" + Dog.getName() + "' success.");
//		list(request, response);
//	}
//
//	protected void view(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		int id = Integer.parseInt(request.getParameter("id"));
//
//		Dog Dog = baseDAO.find(Dog.class, id);
//
//		request.setAttribute("Dog", Dog);
//
//		request.getRequestDispatcher("/viewDog.jsp").forward(request, response);
//	}
//
//	protected void list(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		request.setAttribute("DogList", baseDAO.list(" from Dog "));
//
//		request.getRequestDispatcher("/listDog.jsp").forward(request, response);
//	}
//
//	protected void edit(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		int id = Integer.parseInt(request.getParameter("id"));
//
//		Dog Dog = baseDAO.find(Dog.class, id);
//
//		request.setAttribute("Dog", Dog);
//		request.setAttribute("DogList", baseDAO.list(" from Dog "));
//
//		request.getRequestDispatcher("/addDog.jsp").forward(request, response);
//	}
//
//	protected void save(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		int id = Integer.parseInt(request.getParameter("id"));
//
//		int motherId = Integer.parseInt(request.getParameter("motherId"));
//		String name = request.getParameter("name");
//		String description = request.getParameter("description");
//
//		Dog Dog = baseDAO.find(Dog.class, id);
//		Dog mother = baseDAO.find(Dog.class, motherId);
//
//		Dog.setName(name);
//		Dog.setDescription(description);
//		Dog.setMother(mother);
//
//		boolean hasLoop = false;
//		Dog tmpMother = mother;
//		while (tmpMother != null) {
//			if (tmpMother.getId().intValue() == Dog.getId().intValue()) {
//				hasLoop = true;
//				break;
//			}
//			tmpMother = tmpMother.getMother();
//		}
//
//		if (!hasLoop) {
//			baseDAO.update(Dog);
//			request.setAttribute("msg", "Save '" + Dog.getName() + "' Sucess.");
//		} else {
//			request.setAttribute("msg", "Save fail.");
//		}
//
//		list(request, response);
//	}
//
//	protected void delete(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//
//		int id = Integer.parseInt(request.getParameter("id"));
//
//		Dog Dog = baseDAO.find(Dog.class, id);
//
//		if (Dog != null) {
//
//			List<Dog> DogList = baseDAO
//					.list(" select c from Dog c where c.mother.id = " + id);
//
//			if (DogList.size() > 0) {
//				request.setAttribute("msg", "can't deleted '" + Dog.getName()
//						+ "'.deleted firstly Dog.");
//			} else {
//				baseDAO.delete(Dog);
//
//				request.setAttribute("msg", "delete '" + Dog.getName() + "' Sucess.");
//			}
//		}
//		list(request, response);
//	}
}
