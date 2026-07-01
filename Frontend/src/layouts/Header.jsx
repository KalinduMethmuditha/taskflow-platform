import { useAuth } from '../context/AuthContext';

function Header() {
    const { user } = useAuth();

    return (
        <header className="header">
            <div className="header-brand">
                <h1>TaskFlow</h1>
            </div>
            <div className="header-user">
                <span>{user?.name || 'User'}</span>
            </div>
        </header>
    );
}

export default Header;
