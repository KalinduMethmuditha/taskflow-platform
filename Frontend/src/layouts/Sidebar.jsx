import { NavLink } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';

function Sidebar() {
    const { logout } = useAuth();

    return (
        <aside className="sidebar">
            <nav className="sidebar-nav">
                <NavLink 
                    to="/dashboard" 
                    className={({ isActive }) => isActive ? 'sidebar-link active' : 'sidebar-link'}
                >
                    Dashboard
                </NavLink>
                <NavLink 
                    to="/users" 
                    className={({ isActive }) => isActive ? 'sidebar-link active' : 'sidebar-link'}
                >
                    Users
                </NavLink>
                <NavLink 
                    to="/projects" 
                    className={({ isActive }) => isActive ? 'sidebar-link active' : 'sidebar-link'}
                >
                    Projects
                </NavLink>
                <NavLink 
                    to="/tasks" 
                    className={({ isActive }) => isActive ? 'sidebar-link active' : 'sidebar-link'}
                >
                    Tasks
                </NavLink>
            </nav>
            <div className="sidebar-footer">
                <button onClick={logout} className="sidebar-link logout-btn">
                    Logout
                </button>
            </div>
        </aside>
    );
}

export default Sidebar;
