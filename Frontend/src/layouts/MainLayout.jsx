import { Outlet } from 'react-router-dom';
import Sidebar from './Sidebar';
import Header from './Header';

function MainLayout() {
    return (
        <div className="layout-wrapper">
            <Header />
            <div className="layout-body">
                <Sidebar />
                <main className="layout-main">
                    <Outlet />
                </main>
            </div>
        </div>
    );
}

export default MainLayout;
