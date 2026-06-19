import { Link } from "react-router-dom";

function Sidebar() {
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

        <li className="nav-item">
          <Link className="nav-link text-white" to="/login">
            Logout
          </Link>
        </li>
      </ul>
    </div>
  );
}

export default Sidebar;