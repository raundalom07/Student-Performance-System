import { BrowserRouter, Routes, Route } from "react-router-dom";

import Navbar from "./components/Navbar";
import Sidebar from "./components/Sidebar";

import Login from "./pages/Login";
import Dashboard from "./pages/Dashboard";
import Students from "./pages/Students";
import Predict from "./pages/Predict";
import NotFound from "./pages/NotFound";

function App() {
  return (
    <BrowserRouter>

      <Navbar />

      <div className="d-flex">

        <Sidebar />

        <div className="flex-grow-1 p-4">

          <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/login" element={<Login />} />
            <Route path="/dashboard" element={<Dashboard />} />
            <Route path="/students" element={<Students />} />
            <Route path="/predict" element={<Predict />} />
            <Route path="*" element={<NotFound />} />
          </Routes>

        </div>

      </div>

    </BrowserRouter>
  );
}

export default App;