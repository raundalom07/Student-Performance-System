import { useEffect, useState } from "react";
import { getStudents } from "../services/studentService";

function Students() {

  const [students, setStudents] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    loadStudents();
  }, []);

  const loadStudents = async () => {
    try {

      const response = await getStudents();

      setStudents(
        response.data.data.content
      );

    } catch (error) {
      console.error(error);
    } finally {
      setLoading(false);
    }
  };

  if (loading) {
    return (
      <h3 className="text-center mt-5">
        Loading Students...
      </h3>
    );
  }

  return (
  <div className="container mt-4">

    <div className="d-flex justify-content-between mb-3">
      <h2>Students List</h2>

      <button className="btn btn-primary">
        Add Student
      </button>
    </div>

    <table className="table table-bordered table-striped shadow">

        <thead className="table-dark">
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Attendance</th>
            <th>Internal Marks</th>
            <th>Previous CGPA</th>
          </tr>
        </thead>

        <tbody>

          {students.map((student) => (
            <tr key={student.id}>
              <td>{student.id}</td>
              <td>{student.name}</td>
              <td>{student.attendance}%</td>
              <td>{student.internalMarks}</td>
              <td>{student.previousCgpa}</td>
            </tr>
          ))}

        </tbody>

      </table>

    </div>
  );
}

export default Students;