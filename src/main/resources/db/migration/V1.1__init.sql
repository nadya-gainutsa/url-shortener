create table shortened_urls(
    id text primary key,
    original_url text not null,
    title text not null,
    created_at timestamp not null default now()
);