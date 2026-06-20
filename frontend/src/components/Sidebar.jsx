import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";

function Sidebar() {
  const navigate = useNavigate();
  const handleLogout = () => {
    localStorage.removeItem("token");
    navigate("/login");
  }

  return (
    <div
      className="bg-dark text-white p-3"
      style={{ width: "220px", minHeight: "100vh" }}
    >
      <h4>SPPS</h4>

      <hr />

      <ul className="nav flex-column">
        <li className="nav-item">
          <Link className="nav-link text-white" to="/dashboard">
            Dashboard
          </Link>
        </li>

        <li className="nav-item">
          <Link className="nav-link text-white" to="/students">
            Students
          </Link>
        </li>

        <li className="nav-item">
          <Link className="nav-link text-white" to="/predict">
            Predict
          </Link>
        </li>

        <li
          className="nav-item"
          onClick={handleLogout}
          style={{ cursor: "pointer" }}
        >
          Logout
        </li>
      </ul>
    </div>
  );
}

export default Sidebar;