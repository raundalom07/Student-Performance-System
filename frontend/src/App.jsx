import { BrowserRouter, Routes, Route, useLocation } from "react-router-dom";

import Navbar from "./components/Navbar";
import Sidebar from "./components/Sidebar";

import Login from "./pages/Login";
import Dashboard from "./pages/Dashboard";
import Students from "./pages/Students";
import Predict from "./pages/Predict";
import NotFound from "./pages/NotFound";

function Layout() {
  const location = useLocation();

  const isLoginPage =
    location.pathname === "/" ||
    location.pathname === "/login";

  if (isLoginPage) {
    return (
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    );
  }

  return (
    <>
      <Navbar />

      <div className="d-flex">
        <Sidebar />

        <div className="flex-grow-1 p-4">
          <Routes>
            <Route path="/dashboard" element={<Dashboard />} />
            <Route path="/students" element={<Students />} />
            <Route path="/predict" element={<Predict />} />
            <Route path="*" element={<NotFound />} />
          </Routes>
        </div>
      </div>
    </>
  );
}


function App() {
  return (
    <BrowserRouter>
      <Layout />
    </BrowserRouter>
  );
}

export default App;