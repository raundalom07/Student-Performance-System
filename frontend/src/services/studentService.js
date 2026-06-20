import API from "./api";

export const getStudents = async () => {
  const token = localStorage.getItem("token");

  return API.get("/api/v1/students", {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
};